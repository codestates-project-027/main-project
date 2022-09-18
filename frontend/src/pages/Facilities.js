import styled from 'styled-components';
import TextLogo from '../assets/logo/minimi-text.png';
import Searchbar from '../components/Bar/Searchbar';

import { SearchbarGroupStyle } from '../styles/components/ComponentGroupStyle';
import { FacilitiesPageGlobal } from '../styles/globalStyle/PageGlobalStyle';
import FacilityCardFlex from '../components/Card/FacilityCardFlex';

const FacilitiesPage = () => {
  return (
    <>
      <FacilitiesPageGlobal>
        <SearchbarGroupStyle>
          <img style={{ width: '70px' }} alt="logo" src={TextLogo} />
          <Searchbar />
        </SearchbarGroupStyle>

        <div className="tags--wrapper">
          <div className="title">인기</div>
          <Tags style={{ marginLeft: '30px' }}>배드민턴</Tags>
          <Tags>테니스</Tags>
          <Tags>탁구</Tags>
          <Tags>수영</Tags>
        </div>
        <FacilityCardFlex />
        <FacilityCardFlex />
      </FacilitiesPageGlobal>
    </>
  );
};

export default FacilitiesPage;

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
