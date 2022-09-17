import { Link } from 'react-router-dom';
import { BottomNavbarGlobal } from '../../styles/globalStyle/BarGlobalStyle';
import { BottomNavIconStyle } from '../../styles/components/IconStyles';

import { HiHome } from 'react-icons/hi'; //HiOutlineHome
import { BsPeople, BsPerson } from 'react-icons/bs'; //BsFillPeopleFill, BsFillPersonFill
import { AiOutlineHeart } from 'react-icons/ai'; //AiFillHeart

const BottomNavbar = () => {
  return (
    <BottomNavbarGlobal>
      <BottomNavIconStyle>
        <Link to="/">
          <HiHome />
        </Link>

        <BsPeople />
        <AiOutlineHeart />
        <Link to="/login">
          <BsPerson />
        </Link>
      </BottomNavIconStyle>
    </BottomNavbarGlobal>
    //마이페이지 아이콘 -> 로그인 되어있으면 마이페이지, 안되어있으면 로그인페이지
  );
};

export default BottomNavbar;
