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
import Geocode from 'react-geocode';

const MapPage = ({ fin, setFin, setCity, city }) => {
  const dispatch = useDispatch();
  const locationState = useSelector((state) => state.location);
  const [error, setError] = useState('');
  const { geolocation } = navigator;
  const [loading, setLoading] = useState(false);
  const [data, setData] = useState({ content: [] });
  const locaForMarkers = [];
  //나의 동네 설정

  Geocode.setApiKey(process.env.REACT_APP_GOOGLE_API_KEY);
  Geocode.fromLatLng(
    locationState.currentLocation.latitude,
    locationState.currentLocation.longitude
  ).then((res) => {
    for (let i = 0; i < res.results[0].address_components.length; i++) {
      for (
        let j = 0;
        j < res.results[0].address_components[i].types.length;
        j++
      ) {
        setCity(res.results[0].address_components[1].long_name);
      }
    }
  });

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
          micon="25px"
          margin="0 0 0 -20px"
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

        <FacilityCard
          Flex={'Flex'}
          fin={fin}
          setFin={setFin}
          cmargin="0 0 0 65px"
          margin="0 0 0 0px"
          mmargin="0 0 0 40px"
        />
      </FacilitiesPageGlobal>
    </>
  );
};

export default MapPage;
