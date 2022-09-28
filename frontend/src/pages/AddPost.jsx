import styled from 'styled-components';
import { useState } from 'react';
import { useDispatch } from 'react-redux';
import { useNavigate } from 'react-router-dom';
import { v4 as uuidv4 } from 'uuid';
import { Button } from '../components/Button/Btns';
import {
  TitleTextField,
  ContentsTextField,
} from '../components/InputTextarea/MuiTextFileds';
import { AddPost } from '../redux/CommunitySlice/CommunitySlice';

const WritingPage = () => {
  const dispatch = useDispatch();
  const navigate = useNavigate();
  const [values, setValues] = useState({
    title: '',
    contents: '',
    // username: ''; 회원가입 후 유저아이디
  });

  // const url = 'http://localhost:8080/contents';

  // const GET_COMMUNITY = 'GET_COMMUNITY';
  // const POST_COMMUNITY = 'POST_COMMUNITY';
  // const PATCH_COMMUNITY = 'PATCH_COMMUNITY';

  const handleWriting = () => {
    setValues({ title: '', contents: '' });
    dispatch(
      AddPost({
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
    <PostWrapper>
      <Title>
        <TitleTextField
          value={values.title}
          inputProps={{ type: 'text', placeholder: '제목을 입력해주세요' }}
          onChange={(e) => setValues({ ...values, title: e.target.value })}
        />
      </Title>
      <Contents>
        <ContentsTextField
          value={values.contents}
          inputProps={{
            type: 'text',
            placeholder: '내용을 입력해주세요',
          }}
          onChange={(e) => setValues({ ...values, contents: e.target.value })}
        />
      </Contents>
      <ButtonCSS>
        <Button onClick={handleWriting}>글쓰기</Button>
      </ButtonCSS>
      {/* 태그기능 */}
    </PostWrapper>
  );
};

export default WritingPage;

const PostWrapper = styled.div`
  display: flex;
  flex-direction: column;
  align-items: center;
  width: 100%;
  height: 100%;
  padding: 7rem;
`;

const Title = styled.div`
  display: flex;
  flex-direction: column;
  align-items: center;
  width: 100%;
  height: 100%;
`;

const Contents = styled.div`
  align-items: center;
`;

const ButtonCSS = styled.div`
  display: flex;
  align-items: center;
  margin: 1rem;
`;
