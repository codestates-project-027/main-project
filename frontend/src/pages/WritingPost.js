// import styled from 'styled-components';
import { useState } from 'react';
import Button from '../components/Button/CommunityBtn';
import { CommunityTextField } from '../components/InputTextarea/MuiTextFileds';

const WritingPage = () => {
  const [values, setValues] = useState({
    title: '',
    content: '',
  });

  const handleWriting = () => {
    console.log(values);
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
          value={values.content}
          inputProps={{ type: 'text', placeholder: '내용을 입력해주세요' }}
          onChange={(e) => setValues({ ...values, content: e.target.value })}
        />
      </div>
      <Button onClick={handleWriting}>글쓰기</Button>
      {/* 태그기능 */}
    </div>
  );
};

export default WritingPage;
