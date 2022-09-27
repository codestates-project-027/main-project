import { SearchbarWBtn } from '../components/Bar/Searchbar';
import MapContainer from '../components/Map/MapContainer';
import { BiCurrentLocation } from 'react-icons/bi';
import { FacilitiesPageGlobal } from '../styles/globalStyle/PageGlobalStyle';
import { FacilityCard } from '../components/Card/FacilityCard';

//test에서는 기존의 map page 보관해두고, MAP 에는 내 위치 뽑는거랑, 마커로 경도위도파악 시스템 넣기
//geolocation + 좌표로 거리계산하기
const TestPage = () => {
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

export default TestPage;
