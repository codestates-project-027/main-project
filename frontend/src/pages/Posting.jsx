import styled from 'styled-components';

import PostingID from '../components/Card/PostingID';
import Comments from '../components/Card/Comments';
// import { DeletePostBtn, EditPostBtn } from '../components/Button/Btns';
import { Link, useLocation } from 'react-router-dom';
import { useDispatch } from 'react-redux';
import CommunityCard from '../components/Card/CommunityCard';
import { DeletePost } from '../redux/CommunitySlice/CommunitySlice';

const PostingPage = () => {
  // const params = useParams();
  const dispatch = useDispatch();
  const location = useLocation();
  console.log(location);

  const handleRemovePost = (id) => {
    console.log(id);
    dispatch(DeletePost({ id }));
  };

  return (
    <>
      <PostingCSS>
        <PostingID />
        <CommunityCard
          title={location.state.title}
          contents={location.state.contents}
        />
        {/* useLocation 쓸 때 넘어가는 링크에서 프롭스 내려주기 */}
        <div>
          <Link to="edit-community/:id">
            <button>수정</button>
          </Link>
        </div>
        <div>
          <button onClick={() => handleRemovePost}>삭제</button>
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
  align-items: center;
  justify-content: space-between;
  width: 100;
  height: 100%;
`;
