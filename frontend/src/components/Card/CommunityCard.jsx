import { CommunityCardGlobal } from '../../styles/globalStyle/CardGlobalStyle';
import { useSelector } from 'react-redux';
import {
  UserImageCard,
  Posting,
  Location,
} from '../../styles/components/CardStyle';

const CommunityCard = () => {
  const postings = useSelector((store) => store.community);
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
      </CommunityCardGlobal>
    </>
  );
};
export default CommunityCard;
