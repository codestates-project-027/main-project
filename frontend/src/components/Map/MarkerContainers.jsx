import { useState } from 'react';
import { useMap, MapMarker } from 'react-kakao-maps-sdk';
import { MarkerIconStyle } from '../../styles/components/IconStyles';
import { useSelector } from 'react-redux';
import Pin from '../../assets/icon/map-pin.png';

const MarkerContainer = ({ position, content, main, custom }) => {
  const map = useMap();
  const [isHover, setIsHover] = useState(false);
  const locationState = useSelector((state) => state.location);

  return (
    <>
      <MapMarker
        position={position}
        onClick={(marker) => map.panTo(marker.getPosition())}
        onMouseOver={main||custom ? () => setIsHover(false) : () => setIsHover(true)}
        onMouseOut={() => setIsHover(false)}
        content={'current'}
        image={
          main
            ? {
                src: 'https://images.emojiterra.com/google/noto-emoji/v2.034/128px/1f535.png', // 마커이미지의 주소입니다
                size: {
                  width: 25,
                  height: 25,
                },
              }
            : ''//custom일 때 이미지 다르게
        }
      >
        {isHover && <MarkerIconStyle>{content}</MarkerIconStyle>}
        
      </MapMarker>
    </>
  );
};

export default MarkerContainer;
