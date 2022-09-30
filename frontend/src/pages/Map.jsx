import { SearchbarWBtn } from '../components/Bar/Searchbar';
import MapContainer from '../components/Map/MapContainer';
import { BiCurrentLocation } from 'react-icons/bi';
import { FacilitiesPageGlobal } from '../styles/globalStyle/PageGlobalStyle';
import { FacilityCard } from '../components/Card/FacilityCard';
import { useSelector, useDispatch } from 'react-redux';
import { getLocation } from '../redux/slices/locationSlice';
import { useState, useEffect } from 'react';
import CircularProgressWithLabel from '../components/Bar/Loadingbar';
import axiosInstance from '../api/Interceptor';

const MapPage = () => {
  const dispatch = useDispatch();
  const [error, setError] = useState('');
  const { geolocation } = navigator;
  const [loading, setLoading] = useState(false);

  const handleSuccess = (pos) => {
    const { latitude, longitude } = pos.coords;
    dispatch(getLocation({ currentLocation: { latitude, longitude } }));
    setLoading(false);
  };

  const handleError = (error) => {
    setError(error.message);
  };

  const handleLocation = () => {
    if (!geolocation) {
      setError('Geolocation is not supported.');
      return;
    }
    setLoading(true);
    geolocation.getCurrentPosition(handleSuccess, handleError);
  };

  //example - 시설 빠르게 지우기
  const getFacilityAXIOS = async () => { //76부터 시작
    await axiosInstance.get('/facility/76').then((res) => console.log(res.data.facilityId,res.data));
    // console.log(categoryState);
  };

  const deleteFacilityAXIOS = async () => { //28
    await axiosInstance.delete('/facility/').then((res) => console.log(res.status));
  }

  return (
    <>
      <FacilitiesPageGlobal>
        <SearchbarWBtn
          Icon={
            <BiCurrentLocation
              size="20"
              onClick={() => {
                handleLocation();
              }}
            />
          }
        />
        {loading ? <CircularProgressWithLabel /> : ''}
        <MapContainer />
        <button onClick={getFacilityAXIOS}>get</button>
        <button onClick={deleteFacilityAXIOS}>delete</button>
        <FacilityCard Flex={'Flex'} />
        <FacilityCard Flex={'Flex'} />
        <FacilityCard Flex={'Flex'} />
      </FacilitiesPageGlobal>
    </>
  );
};

export default MapPage;
