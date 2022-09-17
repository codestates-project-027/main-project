import { Link } from 'react-router-dom';
import { NavIconStyle } from '../../styles/IconStyle';
import { BottomNavbarGlobal } from '../../styles/globalStyle/NavbarGlobalStyle';

import { HiHome } from 'react-icons/hi'; //HiOutlineHome
import { BsPeople, BsPerson } from 'react-icons/bs'; //BsFillPeopleFill, BsFillPersonFill
import { AiOutlineHeart } from 'react-icons/ai'; //AiFillHeart

const BottomNavbar = () => {
  return (
    <BottomNavbarGlobal>
      <NavIconStyle>
        <Link to="/">
          <HiHome />
        </Link>

        <BsPeople />
        <AiOutlineHeart />
        <Link to="/login">
          <BsPerson />
        </Link>
      </NavIconStyle>
    </BottomNavbarGlobal>
    //마이페이지 아이콘 -> 로그인 되어있으면 마이페이지, 안되어있으면 로그인페이지
  );
};

export default BottomNavbar;
