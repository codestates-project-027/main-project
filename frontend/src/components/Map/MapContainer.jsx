import { useEffect, useState } from 'react';
import { Map, MapMarker } from 'react-kakao-maps-sdk';
import { MAPSIZE } from '../../constants/style';
import { data } from '../../constants/test-markers';
import MarkerContainer from './MarkerContainers';
import { useSelector, useDispatch } from 'react-redux';
import { getLocation } from '../../redux/slices/locationSlice';

//test

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
        onClick={
          (_t, mouseEvent) =>
            setCustomMarker({
              lat: mouseEvent.latLng.getLat(),
              lng: mouseEvent.latLng.getLng(),
            })
          //dispatch :: custom location coords
        }
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
