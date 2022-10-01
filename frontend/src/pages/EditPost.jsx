import React from 'react';
// import styled from 'styled-components';
import { useState } from 'react';
import { useDispatch, useSelector } from 'react-redux';
import { useNavigate, useParams } from 'react-router-dom';
// import { v4 as uuidv4 } from 'uuid';
import { Button } from '../components/Button/Btns';
import {
  TitleTextField,
  ContentsTextField,
} from '../components/InputTextarea/MuiTextFileds';
// import { AddPost } from '../redux/CommunitySlice/CommunitySlice';
import { EditPost } from '../redux/CommunitySlice/CommunitySlice';

const EditPostPage = () => {
  const params = useParams();
  console.log(params);
  const dispatch = useDispatch();
  const navigate = useNavigate();

  const postings = useSelector((store) => store.community);
  const existingPost = postings.filter((post) => {
    console.log(params.id);
    return post.id === params.id;
  });

  console.log(existingPost);
  const { id, title, contents, username } = existingPost[0];
  const [values, setValues] = useState({
    id: '',
    title: '',
    contents: '',
    username: '',
  });

  //   const url = 'http://localhost:8080/contents';

  //   const GET_COMMUNITY = 'GET_COMMUNITY';
  //   const POST_COMMUNITY = 'POST_COMMUNITY';
  //   const PATCH_COMMUNITY = 'PATCH_COMMUNITY';

  const handleEditPost = () => {
    setValues({ title: '', contents: '', username: '' });
    dispatch(
      EditPost({
        id: params.id,
        title: values.title,
        contents: values.contents,
        username: 'username',
      })
    );
    navigate('/community');

    // const postCommunity = async function(){

    // try {
    // axios.post({
    //   method: 'post',
    //   url: url,
    //   data: {
    //     title: 'title',
    //     contents: 'contents',
    //     username: 'username',
    //   },
    // });
    // console.log(res);
  };

  return (
    <div className="form">
      <div className="wrapper">
        <TitleTextField
          value={values.title}
          onChange={(e) => setValues({ ...values, title: e.target.value })}
          inputProps={{ type: 'text', placeholder: '제목을 입력해주세요' }}
        />
      </div>
      <br />
      <div className="wrapper">
        <ContentsTextField
          value={values.contents}
          onChange={(e) => setValues({ ...values, contents: e.target.value })}
          inputProps={{ type: 'text', placeholder: '내용을 입력해주세요' }}
        />
      </div>
      <Button onClick={handleEditPost}>수정</Button>
      {/* 태그기능 */}
    </div>
  );
};

export default EditPostPage;
