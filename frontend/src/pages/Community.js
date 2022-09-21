// import axios from 'axios';
import styled from 'styled-components';
import { Link } from 'react-router-dom';

import CommunityCard from '../components/Card/CommunityCard';

const CommunityPage = () => {
  //axios
  // const url :
  // axios ({
  //   url:
  // })

  const users = [
    { id: '1', username: '내가만든쿠키', content: '플로깅 하실분' },
    { id: '2', username: '한강에서하자', content: '플로깅이 뭐죠?' },
  ];

  const renderCard = () =>
    users.map((user) => (
      <div>
        <Link to="/community-posting">
          <CommunityCard />
        </Link>
      </div>
    ));
  return (
    <>
      <CSS>
        {users.length ? renderCard() : <p>등록 된 글이 없습니다.</p>}
        <Link to="/community-writing">
          <button>글쓰기</button>
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
