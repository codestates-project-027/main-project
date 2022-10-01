import { CommunityCardGlobal } from '../../styles/globalStyle/CardGlobalStyle';
import {
  UserImageCard,
  Posting,
  Location,
} from '../../styles/components/CardStyle';
// import { DeletePostBtn, EditPostBtn } from '../components/Button/Btns';
// import { Link } from 'react-router-dom';

const CommunityCard = ({ userimg, title, location, contents, time }) => {
  return (
    <>
      <CommunityCardGlobal>
        <UserImageCard>
          <div className="img--wrapper">{userimg}</div>
        </UserImageCard>
        <Posting>
          <div className="content--wrapper">
            <div className="name--wrapper">
              <span className="username">{title}</span>
              <span className="location">{location}</span>
            </div>
            <Location>
              <div className="post">{contents}</div>
            </Location>
          </div>
        </Posting>
        <Location>
          <div className="date">{time}</div>
        </Location>
      </CommunityCardGlobal>
    </>
  );
};
export default CommunityCard;
