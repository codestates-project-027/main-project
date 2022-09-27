import { useState } from 'react';
import { useMap, MapMarker } from 'react-kakao-maps-sdk';
import { MarkerIconStyle } from '../../styles/components/IconStyles';
import { useSelector } from 'react-redux';

const MarkerContainer = ({ position, content }) => {
  const map = useMap();
  const [isHover, setIsHover] = useState(false);
  const locationState = useSelector((state) => state.location);

  return (
    <>
      {/* <MapMarker // 내 위치 마커
        position={{
          lat: locationState.currentLocation.latitude,
          lng: locationState.currentLocation.longitude,
        }}
        draggable={true}
        onClick={(marker) => map.panTo(marker.getPosition())}

      /> */}

      <MapMarker
        position={position}
        onClick={(marker) => map.panTo(marker.getPosition())}
        onMouseOver={() => setIsHover(true)}
        onMouseOut={() => setIsHover(false)}
      >
        {isHover && <MarkerIconStyle>{content}</MarkerIconStyle>}
      </MapMarker>
    </>
  );
};

export default MarkerContainer;
