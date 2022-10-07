import { useEffect, useState } from 'react';
import { Map } from 'react-kakao-maps-sdk';
import { MAPSIZE } from '../../constants/style';
// import { data } from '../../constants/test-markers';
import MarkerContainer from './MarkerContainers';
import { useSelector, useDispatch } from 'react-redux';
import { getLocation } from '../../redux/slices/locationSlice';

const MapContainer = ({ locaForMarkers }) => {
  const dispatch = useDispatch();
  const locationState = useSelector((state) => state.location);
  const [main, setMain] = useState(true);
  const [custom, setCustom] = useState(true);
  const [customMarker, setCustomMarker] = useState({ lat: 0, lng: 0 });

  const myLoca = {
    lat: locationState.currentLocation.latitude,
    lng: locationState.currentLocation.longitude,
  };

  const resetLoca = () => {
    dispatch(
      getLocation({
        currentLocation: { latitude: 37.478147, longitude: 126.86058 },
      })
    );
  };

  const testFunction = (_t, mouseEvent) => {
    setCustomMarker({
      lat: mouseEvent.latLng.getLat(),
      lng: mouseEvent.latLng.getLng(),
    });
    // console.log('clicked');
    //get 요청 보내기.. star 자리로부터 거리계산기
  };

  // const checkAXIOS = async () => {
  //   try {
  //     await axiosInstance
  //       .get(`/facility/76`)
  //       .then((res) => console.log(res.data));
  //   } catch (err) {
  //     console.log(err.response);
  //   }
  // };

  useEffect(() => {}, [locaForMarkers]);

  return (
    <>
      <button style={{ marginBottom: '20px' }} onClick={resetLoca}>
        RESET
      </button>
      {/* <button onClick={getFacilitiesAXIOS}>GET FACILS</button>
      <button onClick={checkAXIOS}>check Facils</button> */}

      <Map
        center={myLoca}
        style={{
          width: MAPSIZE.WIDTH,
          height: MAPSIZE.HEIGHT,
          marginBottom: '20px',
        }}
        level={3}
        onClick={testFunction}
      >
        {customMarker && (
          <MarkerContainer
            key={`MarkerCont-custom`}
            position={customMarker}
            custom={custom}
          />
        )}
        <MarkerContainer
          key={`MarkerCont-main`}
          position={myLoca}
          main={main}
          content={'현재 위치'}
        />
        {locaForMarkers.map((el) => (
          <MarkerContainer
            key={`MarkerCont-${el.id}`}
            position={el.latlng}
            content={el.title}
          />
        ))}
      </Map>
    </>
  );
};

export default MapContainer;
