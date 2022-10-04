import { useState } from 'react';
import { useMap, MapMarker } from 'react-kakao-maps-sdk';
import { MarkerIconStyle } from '../../styles/components/IconStyles';

const MarkerContainer = ({ position, content, main, custom }) => {
  const map = useMap();
  const [isHover, setIsHover] = useState(false);

  return (
    <>
      <MapMarker
        position={position}
        onClick={(marker) => map.panTo(marker.getPosition())}
        onMouseOver={
          main || custom ? () => setIsHover(false) : () => setIsHover(true)
        }
        onMouseOut={() => setIsHover(false)}
        content={'current'}
        image={
          main
            ? {
                src: 'https://images.emojiterra.com/google/noto-emoji/v2.034/128px/1f535.png', // 마커이미지의 주소입니다
                size: {
                  width: 20,
                  height: 20,
                },
              }
            : custom
            ? {
                src: 'https://t1.daumcdn.net/localimg/localimages/07/mapapidoc/markerStar.png', // 마커이미지의 주소입니다
                size: {
                  width: 24,
                  height: 35,
                },
              }
            : ''
        }
      >
        {isHover && <MarkerIconStyle>{content}</MarkerIconStyle>}
      </MapMarker>
    </>
  );
};

export default MarkerContainer;
