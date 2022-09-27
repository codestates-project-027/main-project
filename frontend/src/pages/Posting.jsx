import styled from 'styled-components';

import PostingID from '../components/Card/PostingID';
import Comments from '../components/Card/Comments';
import { DeletePostBtn, EditPostBtn } from '../components/Button/Btns';

const PostingPage = () => {
  return (
    <>
      <PostingCSS>
        <PostingID />
        <div>글내용</div>
        <div>
          <EditPostBtn />
        </div>
        <div>
          <DeletePostBtn />
        </div>
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
