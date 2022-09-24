import { SearchbarWBtn } from '../components/Bar/Searchbar';

import MapContainer from '../components/Map/MapContainer';

import { BiCurrentLocation } from 'react-icons/bi';

import { FacilitiesPageGlobal } from '../styles/globalStyle/PageGlobalStyle';
import { FacilityCard } from '../components/Card/FacilityCard';

const MapPage = () => {
  return (
    <>
      <FacilitiesPageGlobal>
        <SearchbarWBtn Icon={<BiCurrentLocation size="20" />} />
        <MapContainer />
        <FacilityCard Flex={'Flex'} />
        <FacilityCard Flex={'Flex'} />
        <FacilityCard Flex={'Flex'} />
      </FacilitiesPageGlobal>
    </>
  );
};

export default MapPage;
