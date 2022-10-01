import { useEffect, useState } from 'react';
import { Map, MapMarker } from 'react-kakao-maps-sdk';
import { MAPSIZE } from '../../constants/style';
import { data } from '../../constants/test-markers';
import MarkerContainer from './MarkerContainers';
import { useSelector, useDispatch } from 'react-redux';
import { getLocation } from '../../redux/slices/locationSlice';
import axiosInstance from '../../api/Interceptor';

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
        currentLocation: { latitude: 37.478147, longitude: 126.86058 },
      })
    );
  };

  const testFunction = (_t, mouseEvent) => {
    setCustomMarker({
      lat: mouseEvent.latLng.getLat(),
      lng: mouseEvent.latLng.getLng(),
    });
    console.log('clicked');
    //get 요청 보내기.. star 자리로부터 거리계산기
  };

  const getFacilitiesAXIOS = async () => {
    try {
      await axiosInstance
        .get(`/facility?location=${37.478147}%2C+${126.86058}&page=1`)
        .then((res) => console.log(res));
    } catch (err) {
      console.log(err.response);
    }
  };

  const checkAXIOS = async () => {
    try {
      await axiosInstance
        .get(`/facility/76`)
        .then((res) => console.log(res.data));
    } catch (err) {
      console.log(err.response);
    }
  };
  //76: photoList, status, location, website : 무에타이
  //77: photolist, status,, location: 37,478134, 126.861461 : 탁구
  //78: pthotoList, info, status, phone, web, loca: 37.477953, 126.860214" : 수영
  //요청 보낼 때 파일 담기
  //79: photoList.. 다시 담기

  useEffect(() => {}, [locationState]);

  return (
    <>
      <button onClick={resetLoca}>RESET</button>
      <button onClick={getFacilitiesAXIOS}>GET FACILS</button>
      <button onClick={checkAXIOS}>check Facils</button>

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
