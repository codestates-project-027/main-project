import { SearchbarWBtn } from '../components/Bar/Searchbar';
import MapContainer from '../components/Map/MapContainer';
import { BiCurrentLocation } from 'react-icons/bi';
import { FacilitiesPageGlobal } from '../styles/globalStyle/PageGlobalStyle';
import { FacilityCard } from '../components/Card/FacilityCard';
import { useCurrentLocation } from '../HooksAndUtils/Hooks';
import { useSelector, useDispatch } from 'react-redux';
import { getLocation } from '../redux/slices/locationSlice';
import { useState, useEffect } from 'react';

const MapPage = () => { //두번 클릭해야 작동하고 새로고침해야 화면이 나오는 문제
  const dispatch = useDispatch();
  const locationState = useSelector((state) => state.location);
  const [location, setLocation] = useState();
  const [error, setError] = useState();
  const { geolocation } = navigator;

  const handleSuccess = (pos) => {
    const { latitude, longitude } = pos.coords;
    setLocation({ latitude, longitude });
  };

  const handleError = (error) => {
    setError(error.message);
  };
  const handleLocation = () => {
    if (!geolocation) {
      setError('Geolocation is not supported.');
      return;
    }
    geolocation.getCurrentPosition(handleSuccess, handleError);
    if (location !== undefined) {
      dispatch(getLocation({ currentLocation: location }));
    }
    console.log('located');
  };

  useEffect(() => {}, [locationState]);

  return (
    <>
      <FacilitiesPageGlobal>
        <SearchbarWBtn
          Icon={<BiCurrentLocation size="20" onClick={handleLocation} />}
        />
        <MapContainer location={location} />
        <FacilityCard Flex={'Flex'} />
        <FacilityCard Flex={'Flex'} />
        <FacilityCard Flex={'Flex'} />
      </FacilitiesPageGlobal>
    </>
  );
};

export default MapPage;
