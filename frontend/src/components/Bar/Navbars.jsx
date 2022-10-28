import { Link } from 'react-router-dom';
// import { IoIosArrowDown } from 'react-icons/io';

import {
  CommunityTopNavbarGlobal,
  TopNavbarGlobal,
  BottomNavbarGlobal,
} from '../../styles/globalStyle/BarGlobalStyle';

import {
  BottomNavIconStyle,
  IconWrapper,
} from '../../styles/components/IconStyles';

import { BiBell, BiBuildingHouse, BiMap } from 'react-icons/bi';
import { HiHome } from 'react-icons/hi'; //HiOutlineHome
import { BsPerson } from 'react-icons/bs'; //BsFillPeopleFill, BsFillPersonFill
// import { AiOutlineHeart } from 'react-icons/ai'; //AiFillHeart

export const TopNavbar = ({ type }) => {
  return (
    <>
      <TopNavbarGlobal>
        <div className="tab--wrapper">
          {type}
          {/* <IconWrapper marginLeft={'10px'}>
            <IoIosArrowDown size="23" />
          </IconWrapper> */}
        </div>
        <div className="icon--wrapper">
          <Link to="alarms">
            <BiBell size="23" />
          </Link>
        </div>
      </TopNavbarGlobal>
    </>
  );
};

export const CommunityTopNavbar = ({ type }) => {
  return (
    <>
      <CommunityTopNavbarGlobal>
        <div className="tab--wrapper">
          {type}
          {/* <IconWrapper marginLeft={'10px'}>
            <IoIosArrowDown size="23" />
          </IconWrapper> */}
        </div>
        <div className="icon--wrapper">
          <BiBell size="23" />
        </div>
      </CommunityTopNavbarGlobal>
    </>
  );
};

export const BottomNavbar = ({ fin, setFin }) => {
  const handleMove = () => {
    if (setFin !== undefined) {
      setFin(!fin);
    }
  };
  return (
    <BottomNavbarGlobal>
      <BottomNavIconStyle>
        <Link to="/">
          <HiHome />
        </Link>
        <Link to="/facility">
          <BiBuildingHouse onClick={() => handleMove()} />
        </Link>
        <Link to="/map">
          <BiMap />
        </Link>
        <Link to="/mypage">
          <BsPerson />
        </Link>
      </BottomNavIconStyle>
    </BottomNavbarGlobal>
  );
};
