// import axios from 'axios';
import styled from 'styled-components';
import { Link } from 'react-router-dom';
import { useSelector } from 'react-redux';

import { CommunityCardGlobal } from '../styles/globalStyle/CardGlobalStyle';
import { UserImageCard } from '../styles/components/CardStyle';
import { Button } from '../components/Button/Btns';
import { Posting, Location } from '../styles/components/CardStyle';

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
      <Div>
        <Render>
          {postings.length ? renderCard() : <p>등록 된 글이 없습니다.</p>}
        </Render>
        <Link to="/community-writing">
          <span>
            <Button>글쓰기</Button>
          </span>
        </Link>
      </Div>
    </>
  );
};

export default CommunityPage;

const Div = styled.div`
  display: flex;
  flex-direction: column;
  align-items: center;
  bottom: 0;
`;

const Render = styled.div`
  margin-top: 5rem;
  width: 50vw;
  height: 50vh;
`;
