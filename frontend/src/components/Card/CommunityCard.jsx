import { CommunityCardGlobal } from '../../styles/globalStyle/CardGlobalStyle';
import { useSelector } from 'react-redux';
// import { Link } from 'react-router-dom';
import {
  UserImageCard,
  Posting,
  Location,
} from '../../styles/components/CardStyle';

import { EditPostBtn } from '../Button/Btns';

const CommunityCard = () => {
  const postings = useSelector((store) => store.community);
  console.log(postings);

  return (
    <>
      <CommunityCardGlobal>
        <UserImageCard>
          <div className="img--wrapper">유저이미지</div>
        </UserImageCard>
        <Posting>
          <div className="content--wrapper">
            <div className="name--wrapper">
              <span className="username">{postings.title}</span>
              <span className="location">서대문구 충현동</span>
            </div>
            <Location>
              <div className="post">{postings.contents}</div>
            </Location>
          </div>
        </Posting>
        <Location>
          <div className="date">2022.10.03</div>
        </Location>
        <div>
          <EditPostBtn />
        </div>
        <div>
          <button>삭제</button>
        </div>
      </CommunityCardGlobal>
    </>
  );
};
export default CommunityCard;
