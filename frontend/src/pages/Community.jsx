// import axios from 'axios';
import styled from 'styled-components';
import { Link } from 'react-router-dom';
import { useSelector } from 'react-redux';

import { CommunityCardGlobal } from '../styles/globalStyle/CardGlobalStyle';
import { UserImageCard } from '../styles/components/CardStyle';
import { Button } from '../components/Button/Btns';
import { Posting, Location } from '../styles/components/CardStyle';
import { Searchbar } from '../components/Bar/Searchbar';

const CommunityPage = () => {
  const postings = useSelector((store) => store.community);

  const renderCard = () =>
    postings.map((posting) => (
      <div key={posting.id}>
        <Link to="/community-posting">
          <CommunityCardGlobal>
            <UserImageCard>
              <div className="img--wrapper">유저이미지</div>
            </UserImageCard>
            <Posting>
              <div className="content--wrapper">
                <div className="name--wrapper">
                  <span className="username">{posting.title}</span>
                  <span className="location">서대문구 충현동</span>
                </div>
                <Location>
                  <div className="post">{posting.contents}</div>
                </Location>
              </div>
            </Posting>
            <Location>
              <div className="date">2022.10.03</div>
            </Location>
          </CommunityCardGlobal>
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

export default CommunityPage;

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
  margin-top: 5rem;
  width: 50vw;
  height: 50vh;
`;
