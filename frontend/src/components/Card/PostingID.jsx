import styled from 'styled-components';

const PostingID = () => {
  return (
    <>
      <PostingCSS>
        <div className="userInfo">
          <div>user image</div>
          <div>닉네임</div>
          <div>날짜</div>
        </div>
      </PostingCSS>
    </>
  );
};

export default PostingID;

const PostingCSS = styled.div`
  display: flex;
  flex-direction: column;
  border: 1px solid black;
`;
