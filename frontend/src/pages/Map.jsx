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
// import { getFacilities } from '../redux/slices/facilityListSlice';

const MapPage = ({ fin, setFin }) => {
  const dispatch = useDispatch();
  const locationState = useSelector((state) => state.location);
  const [error, setError] = useState('');
  const { geolocation } = navigator;
  const [loading, setLoading] = useState(false);
  const [data, setData] = useState({ content: [] });
  const locaForMarkers = [];

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

  const getFacilitiesAXIOS = async () => {
    const response = await axiosInstance.get(
      '/facility?location=' +
        locationState.currentLocation.latitude +
        '%2C' +
        locationState.currentLocation.longitude +
        '&page=1'
    );
    setData(response.data.content);
  };

  if (data.length !== undefined) {
    data.map((el) =>
      locaForMarkers.push({
        id: el.facilityId,
        title: el.facilityName,
        latlng: {
          lat: el.location.split(',')[0],
          lng: el.location.split(',')[1],
        },
      })
    );
  }

  useEffect(() => {
    getFacilitiesAXIOS();
  }, []);

  return (
    <>
      <FacilitiesPageGlobal>
        <SearchbarWBtn
          margin="0 0 0 20px"
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
        <div className="map">
          <MapContainer locaForMarkers={locaForMarkers} />
        </div>
        {/* <button onClick={getFacilityAXIOS}>get</button>
        <button onClick={deleteFacilityAXIOS}>delete</button> */}
        <FacilityCard Flex={'Flex'} fin={fin} setFin={setFin} />
      </FacilitiesPageGlobal>
    </>
  );
};

export default MapPage;
