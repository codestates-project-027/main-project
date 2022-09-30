import { useEffect, useState } from 'react';
import { Map, MapMarker } from 'react-kakao-maps-sdk';
import { MAPSIZE } from '../../constants/style';
import { data } from '../../constants/test-markers';
import MarkerContainer from './MarkerContainers';
import { useSelector, useDispatch } from 'react-redux';
import { getLocation } from '../../redux/slices/locationSlice';

const MapContainer = () => {
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
        //광명 { latitude: 37.47814, longitude: 126.86058 }
        //제주 { latitude: 33.450701, longitude: 126.570667 }
        currentLocation: { latitude: 37.478147, longitude: 126.860580 },
      })
    );
  };

  const testFunction = (_t, mouseEvent) => {
    setCustomMarker({
      lat: mouseEvent.latLng.getLat(),
      lng: mouseEvent.latLng.getLng(),
    });
    console.log('clicked')
    //get 요청 보내기.. star 자리로부터 거리계산기
  };

  useEffect(() => {}, [locationState]);

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
