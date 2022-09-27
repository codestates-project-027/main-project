// import styled from 'styled-components';
import { useState } from 'react';
import { useDispatch } from 'react-redux';
import { useNavigate } from 'react-router-dom';
import Button from '../components/Button/CommunityBtn';
import { CommunityTextField } from '../components/InputTextarea/MuiTextFileds';
import { WritingPost } from '../redux/CommunitySlice/CommunitySlice';

const WritingPage = () => {
  const dispatch = useDispatch();
  const navigate = useNavigate();
  const [values, setValues] = useState({
    title: '',
    contents: '',
  });

  const handleWriting = () => {
    setValues({ title: '', contents: '' });
    dispatch(
      WritingPost({
        id: '3',
        title: values.title,
        contents: values.contents,
      })
    );
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
      <Button onClick={handleWriting}>글쓰기</Button>
      {/* 태그기능 */}
    </div>
  );
};

export default WritingPage;
