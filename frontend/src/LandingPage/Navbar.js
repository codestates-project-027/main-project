import styled from 'styled-components';
import { Link } from 'react-router-dom';
import { HiHome } from 'react-icons/hi'; //HiOutlineHome
import { BsPeople, BsPerson } from 'react-icons/bs'; //BsFillPeopleFill, BsFillPersonFill
import { AiOutlineHeart } from 'react-icons/ai'; //AiFillHeart

const Navbar = () => {
  return (
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
    //마이페이지 아이콘 -> 로그인 되어있으면 마이페이지, 안되어있으면 로그인페이지
  );
};

export default Navbar;

const NavIconStyle = styled.div`
  display: flex;
  justify-content: space-around;
  align-items: center;
  margin-left: 1%;
  width: 55%;
  font-size: 1.8em;
`;
