// import axios from 'axios';
import styled from 'styled-components';
import { Link } from 'react-router-dom';
import { useSelector } from 'react-redux';

import { Button } from '../components/Button/Btns';
import { Searchbar } from '../components/Bar/Searchbar';
import CommunityCard from '../components/Card/CommunityCard';

const CommunityList = () => {
  const postings = useSelector((store) => store.community);

  const renderCard = () =>
    postings.map(({ id, title, location, contents, time }) => (
      <div key={id}>
        <Link
          to="/community-posting"
          state={{ id, title, location, contents, time }}
        >
          <CommunityCard
            title={title}
            location={location}
            contents={contents}
            time={time}
          />
        </Link>
      </div>
    ));
  return (
    <>
      <CommunityWrapper>
        <UpperBar>
          <Searchbar placeholder="우리동네 소식찾기" />
          <Link to="/community-writing">
            <Button>글쓰기</Button>
          </Link>
        </UpperBar>
        <Render>
          {postings.length ? renderCard() : <p>등록 된 글이 없습니다.</p>}
        </Render>
      </CommunityWrapper>
    </>
  );
};

export default CommunityList;

const CommunityWrapper = styled.div`
  display: flex;
  flex-direction: column;
  margin: 0rem 5rem 0 5rem;
  align-items: center;
`;

const UpperBar = styled.div`
  display: flex;
  justify-content: space-between;
  width: 100%;
  position: relative;
`;

const Render = styled.div`
  display: flex;
  flex-direction: column;
  justify-content: space-between;
  margin-top: 5rem;
  width: 50vw;
  height: 50vh;
`;
