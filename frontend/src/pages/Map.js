import { SearchbarWBtn } from '../components/Bar/Searchbar';

import MapContainer from '../components/Map/MapContainer';

import { BiCurrentLocation } from 'react-icons/bi';

import { FacilitiesPageGlobal } from '../styles/globalStyle/PageGlobalStyle';
import { FacilityCardFlex } from '../components/Card/FacilityCard';

const MapPage = () => {
  return (
    <>
      <FacilitiesPageGlobal>
        <SearchbarWBtn Icon={<BiCurrentLocation size="20" />} />
        <MapContainer />
        <FacilityCardFlex />
        <FacilityCardFlex />
        <FacilityCardFlex />
      </FacilitiesPageGlobal>
    </>
  );
};

export default MapPage;
