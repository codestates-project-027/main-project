import React from 'react';
// import styled from 'styled-components';
import { useState } from 'react';
import { useDispatch } from 'react-redux';
import { useNavigate, useParams } from 'react-router-dom';
import { v4 as uuidv4 } from 'uuid';
import { Button } from '../components/Button/Btns';
import { CommunityTextField } from '../components/InputTextarea/MuiTextFileds';
import { WritingPost } from '../redux/CommunitySlice/CommunitySlice';

const EditPostPage = () => {
  const dispatch = useDispatch();
  const navigate = useNavigate();
  const [values, setValues] = useState({
    title: '',
    contents: '',
    // username: ''; 회원가입 후 유저아이디
  });

  //   const url = 'http://localhost:8080/contents';

  //   const GET_COMMUNITY = 'GET_COMMUNITY';
  //   const POST_COMMUNITY = 'POST_COMMUNITY';
  //   const PATCH_COMMUNITY = 'PATCH_COMMUNITY';

  const handleEditPost = () => {
    const params = useParams;
    console.log(params.id);
    setValues({ title: '', contents: '' });
    dispatch(
      WritingPost({
        id: uuidv4(),
        title: values.title,
        contents: values.contents,
        username: 'username',
      })
    );
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

    navigate('/community');
  };

  return (
    <div className="form">
      <div className="wrapper">
        <CommunityTextField
          value={values.title}
          inputProps={{ type: 'text', placeholder: '제목을 입력해주세요' }}
          onChange={(e) => setValues({ ...values, title: e.target.value })}
        />
      </div>
      <br />
      <div className="wrapper">
        <CommunityTextField
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
