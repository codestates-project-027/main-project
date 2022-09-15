import styled from 'styled-components';
import Logo from '../LandingPage/Logo';
import Searchbar from '../LandingPage/Searchbar';
import { LogoAndSearchStyle } from '../LandingPage/LandingPage';
import FacilityCardForList from './FacilityCardForList';

const FacilityListPage = () => {
  return (
    <>
      <FacilityListPageStyle>
        <LogoAndSearchStyle>
          <Logo />
          <Searchbar />
        </LogoAndSearchStyle>

        <div className="tags--wrapper">
          <div className="title">인기</div>
          <Tags style={{ marginLeft: '30px' }}>배드민턴</Tags>
          <Tags>테니스</Tags>
          <Tags>탁구</Tags>
          <Tags>수영</Tags>
        </div>
      </FacilityListPageStyle>

      <FacilityCardForList />
      <FacilityCardForList />
    </>
  );
};

export default FacilityListPage;

const FacilityListPageStyle = styled.div`
  display: flex;
  justify-content: center;
  align-items: center;
  flex-direction: column;
  width: 100%;
  .tags--wrapper {
    display: flex;
    justify-content: flex-start;
    align-items: center;
    width: 40%;
    margin: 15px;
    @media screen and (max-width: 790px) {
      width: 55%;
    }
    .title {
      margin-left: 10px;
    }
  }
`;

const Tags = styled.div`
  display: flex;
  background: bisque;
  margin: 7px;
  margin-left: 15px;
  padding: 5px;
  padding-left: 8px;
  padding-right: 8px;
  border-radius: 8px;
`;
