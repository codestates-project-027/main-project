import Logo from './Logo';
import Searchbar from './Searchbar';
import styled from 'styled-components';

const LandingPage = () => {
  return (
    <>
      <LogoAndSearchStyle>
        <Logo />
        <Searchbar />
      </LogoAndSearchStyle>
    </>
  );
};

export default LandingPage;

const LogoAndSearchStyle = styled.div`
  display: flex;
  justify-content: center;
  align-items: center;
  width: 60%;
`;
