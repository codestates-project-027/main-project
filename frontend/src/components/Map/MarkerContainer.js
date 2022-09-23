import { useState } from 'react';
import { useMap, MapMarker } from 'react-kakao-maps-sdk';
import { MarkerIconStyle } from '../../styles/components/IconStyles';

const MarkerContainer = ({ position, content }) => {
  const map = useMap();
  const [isHover, setIsHover] = useState(false);

  return (
    <MapMarker
      position={position}
      onClick={(marker) => map.panTo(marker.getPosition())}
      onMouseOver={() => setIsHover(true)}
      onMouseOut={() => setIsHover(false)}
    >
      {isHover && <MarkerIconStyle>{content}</MarkerIconStyle>}
    </MapMarker>
  );
};

export default MarkerContainer;
