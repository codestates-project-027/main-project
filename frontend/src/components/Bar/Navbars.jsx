import { Link, useParams } from 'react-router-dom';
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

import PATH from '../../routes/routePath';

import { BiBell, BiBuildingHouse, BiMap } from 'react-icons/bi';
import { HiHome, HiOutlineHome } from 'react-icons/hi';
import { RiBuildingFill, RiMapPin2Fill } from 'react-icons/ri';
import { BsPerson, BsFillPersonFill } from 'react-icons/bs';
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
  const cpath = window.location.pathname;
  const handleMove = () => {
    if (setFin !== undefined) {
      setFin(!fin);
    }
  };

  return (
    <BottomNavbarGlobal>
      <BottomNavIconStyle>
        <Link to={PATH.MAIN}>
          {cpath === PATH.MAIN ? <HiHome /> : <HiOutlineHome />}
        </Link>
        <Link to={PATH.FACILITIES}>
          {cpath === PATH.FACILITIES ? (
            <RiBuildingFill onClick={() => handleMove()} />
          ) : (
            <BiBuildingHouse onClick={() => handleMove()} />
          )}
        </Link>
        <Link to="/map">
          {cpath === PATH.MAP ? <RiMapPin2Fill /> : <BiMap />}
        </Link>
        <Link to="/mypage">
          {cpath === PATH.MYPAGE ? <BsFillPersonFill /> : <BsPerson />}
        </Link>
      </BottomNavIconStyle>
    </BottomNavbarGlobal>
  );
};
