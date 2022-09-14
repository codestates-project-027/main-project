import styled from 'styled-components';
// import { FcReddit } from 'react-icons/fc';
import { FcReddit } from 'react-icons/fc';
const Logo = () => {
  return (
    <>
      <LogoIcon>
        <FcReddit size="30px" />
      </LogoIcon>

      <LogoStyle>미니미</LogoStyle>
    </>
  );
};

export default Logo;

const LogoStyle = styled.div`
  font-family: 'Bazzi';
  font-size: 50px;
  color: var(--logo-yellow);
  cursor: pointer;

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
  @media screen and (max-width: 1526px) {
    display: none;
  }
  @media screen and (max-width: 790px) {
    display: flex;
  }
`;
