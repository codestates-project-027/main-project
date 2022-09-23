import styled from 'styled-components';

import PostingID from '../components/Card/PostingID';
import Comments from '../components/Card/Comments';

const PostingPage = () => {
  return (
    <>
      <PostingCSS>
        <PostingID />
        <div>글내용</div>
        <Comments />
      </PostingCSS>
    </>
  );
};

export default PostingPage;

const PostingCSS = styled.div`
  display: flex;
  flex-direction: column;
`;
