// import axios from 'axios';
import styled from 'styled-components';
import { Link } from 'react-router-dom';
import { useSelector } from 'react-redux';

import CommunityCard from '../components/Card/CommunityCard';
import Button from '../components/Button/CommunityBtn';

const CommunityPage = () => {
  const postings = useSelector((store) => store.postings);
  console.log(postings);

  //axios
  // const url :
  // axios ({
  //   url:
  // })

  // const postings = [
  //   { id: '1', username: '내가만든쿠키', content: '플로깅 하실분' },
  //   { id: '2', username: '한강에서하자', content: '플로깅이 뭐죠?' },
  // ];

  const renderCard = () =>
    postings.map((posting) => (
      <div key={posting.title}>
        <Link to="/community-posting">
          <CommunityCard />
        </Link>
      </div>
    ));
  return (
    <>
      <CSS>
        {postings.length ? renderCard() : <p>등록 된 글이 없습니다.</p>}
        <Link to="/community-writing">
          <Button>글쓰기</Button>
        </Link>
      </CSS>
    </>
  );
};

export default CommunityPage;

const CSS = styled.div`
  display: flex;
  flex-direction: column;
  justify-content: space-between;
  height: 95%;
`;
