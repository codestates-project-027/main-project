import { useEffect, useState } from 'react';
import { Map } from 'react-kakao-maps-sdk';
import { MAPSIZE } from '../../constants/style';
import { data } from '../../constants/test-markers';
import MarkerContainer from './MarkerContainer';
import { useSelector, useDispatch } from 'react-redux';
import { getLocation } from '../../redux/slices/locationSlice';

//test

const MapContainer = ({ location }) => {
  const dispatch = useDispatch();
  const locationState = useSelector((state) => state.location);

  const [myLoca, setMyLoca] = useState({
    lat: locationState.currentLocation.latitude,
    lng: locationState.currentLocation.longitude,
  });
  //33.450701, 126.570667
  const resetLoca = () => {
    dispatch(getLocation({ currentLocation: '3' }));
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
      >
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
