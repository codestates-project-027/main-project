import styled from 'styled-components';
import { FcReddit } from 'react-icons/fc';
import { Link } from 'react-router-dom';

const Logo = () => {
  return (
    <>
      <Link to="/" style={LinkStyle}>
        <LogoIcon>
          <FcReddit size="30px" />
        </LogoIcon>

        <LogoStyle>미니미</LogoStyle>
      </Link>
    </>
  );
};

export default Logo;

const LogoStyle = styled.div`
  /* background-color: red; */
  font-family: 'Bazzi';
  font-size: 50px;
  color: var(--logo-yellow);
  cursor: pointer;
  margin-left: -20px;

  @media screen and (max-width: 1097px) {
    font-size: 37px;
  }

  @media screen and (max-width: 875px) {
    font-size: 30px;
  }

  @media screen and (max-width: 790px) {
    display: none;
  }
`;

const LogoIcon = styled.div`
  @media screen and (max-width: 3000px) {
    display: none;
  }
  @media screen and (max-width: 790px) {
    display: flex;
  }
`;

export const LinkStyle = {
  textDecoration: 'none',
};
