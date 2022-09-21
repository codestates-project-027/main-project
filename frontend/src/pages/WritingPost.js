// import styled from 'styled-components';

const WritingPage = () => {
  return (
    <div className="form">
      <div className="wrapper">
        <input
          className="title"
          type="text"
          placeholder="제목을 입력해주세요"
        />
      </div>
      <div className="wrapper">
        <textarea
          className="content"
          type="text"
          placeholder="내용을 입력해주세요"
        />
      </div>
      <button>글쓰기</button>
      {/* <div className="wrapper">
        <div className="main-first">Tag</div>
        <div className="main">
          태그기능
        </div>
      </div> */}
    </div>
  );
};

export default WritingPage;
