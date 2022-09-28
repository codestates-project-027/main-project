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
import { editPost } from '../redux/CommunitySlice/CommunitySlice';

const EditPostPage = () => {
  const posting = useSelector((store) => store.community);
  const params = useParams();
  const dispatch = useDispatch();
  const navigate = useNavigate();

  console.log(posting);
  const existingPost = posting.filter((post) => post.id === params.id);
  console.log(existingPost);
  const { title, contents, username } = existingPost[0];
  const [values, setValues] = useState({
    title,
    contents,
    username,
  });

  //   const url = 'http://localhost:8080/contents';

  //   const GET_COMMUNITY = 'GET_COMMUNITY';
  //   const POST_COMMUNITY = 'POST_COMMUNITY';
  //   const PATCH_COMMUNITY = 'PATCH_COMMUNITY';

  const handleEditPost = () => {
    setValues({ title: '', contents: '', username: '' });
    dispatch(
      editPost({
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
          inputProps={{ type: 'text', placeholder: '제목을 입력해주세요' }}
          onChange={(e) => setValues({ ...values, title: e.target.value })}
        />
      </div>
      <br />
      <div className="wrapper">
        <ContentsTextField
          value={values.contents}
          inputProps={{ type: 'text', placeholder: '내용을 입력해주세요' }}
          onChange={(e) => setValues({ ...values, contents: e.target.value })}
        />
      </div>
      <Button onClick={handleEditPost}>수정</Button>
      {/* 태그기능 */}
    </div>
  );
};

export default EditPostPage;
