import { useState } from 'react';
import { Map } from 'react-kakao-maps-sdk';
import { MAPSIZE } from '../../constants/style';
import { data } from '../../constants/test-markers';
import MarkerContainer from './MarkerContainer';

const MapContainer = () => {
  const [myLoca, setMyLoca] = useState({ lat: 33.450701, lng: 126.570667 });
  return (
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
  );
};

export default MapContainer;
