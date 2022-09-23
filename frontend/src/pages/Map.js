import TextLogo from '../assets/logo/minimi-text.png';
import Searchbar from '../components/Bar/Searchbar';
import { SquareBtn } from '../components/Button/Btns';
import MapContainer from '../components/Map/MapContainer';

import { BiCurrentLocation } from 'react-icons/bi';

import { SearchbarGroupStyle } from '../styles/components/ComponentGroupStyle';
import { FacilitiesPageGlobal } from '../styles/globalStyle/PageGlobalStyle';
import { FacilityCardFlex } from '../components/Card/FacilityCard';

const MapPage = () => {
  return (
    <>
      <FacilitiesPageGlobal>
        <SearchbarGroupStyle style={{ margin: '30px' }}>
          <img style={{ width: '70px' }} alt="logo" src={TextLogo} />
          <Searchbar />
          <SquareBtn>
            <BiCurrentLocation size="20" />
          </SquareBtn>
        </SearchbarGroupStyle>
        <MapContainer />
        <FacilityCardFlex />
        <FacilityCardFlex />
        <FacilityCardFlex />
      </FacilitiesPageGlobal>
    </>
  );
};

export default MapPage;
