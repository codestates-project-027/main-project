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
      <BsPerson />
    </NavIconStyle>
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
