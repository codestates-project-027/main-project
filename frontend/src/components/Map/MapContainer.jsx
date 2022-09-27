import { useEffect, useState } from 'react';
import { Map, MapMarker } from 'react-kakao-maps-sdk';
import { MAPSIZE } from '../../constants/style';
import { data } from '../../constants/test-markers';
import MarkerContainer from './MarkerContainers';
import { useSelector, useDispatch } from 'react-redux';
import { getLocation } from '../../redux/slices/locationSlice';

const MapContainer = ({ location }) => {
  const dispatch = useDispatch();
  const locationState = useSelector((state) => state.location);
  const [main, setMain] = useState(true);
  const [custom, setCustom] = useState(true);
  const [customMarker, setCustomMarker] = useState();

  const [myLoca, setMyLoca] = useState({
    lat: locationState.currentLocation.latitude,
    lng: locationState.currentLocation.longitude,
  });

  const resetLoca = () => {
    dispatch(
      getLocation({
        currentLocation: { latitude: 33.450701, longitude: 126.570667 },
      })
    );
    console.log(locationState);
  };

  const testFunction = (_t, mouseEvent) => {
    setCustomMarker({
      lat: mouseEvent.latLng.getLat(),
      lng: mouseEvent.latLng.getLng(),
    });
    //여기에 center로 panning시키는 + axios 요청 함수를 써보려고 console.log()함수를 테스트로 먼저 넣어봤는데
    //작동이 안되었습니다.
  };

  return (
    <>
      <button onClick={resetLoca}>RESET</button>

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
        {data.map((el) => (
          <MarkerContainer
            key={`MarkerCont-${el.latlng.lat}-${el.latlng.lng}`}
            position={el.latlng}
            content={el.title}
          />
        ))}
      </Map>
    </>
  );
};

export default MapContainer;
