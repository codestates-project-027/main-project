import DaumPostcode from 'react-daum-postcode';
import { useState } from 'react';
import { ModalBackdropStyle } from '../../styles/components/ModalStyle';
import axios from 'axios';
const { kakao } = window;

const AddressUploader = () => {
  const [openPostcode, setOpenPostcode] = useState(false);
  const [address, setAddress] = useState('');
  const [data, setData] = useState('');

  const handleAddress = {
    clickButton: () => {
      setOpenPostcode((current) => !current);
    },

    selectAddress: (data) => {
      setAddress(data.address);
      setOpenPostcode(false);
      console.log(address);
      geoCoding();
    },
  };

  const handleModal = () => {
    setOpenPostcode(false);
  };

  //주소 -> 좌표변환
  const geoCoding = () => {
    const geocoder = new kakao.maps.services.Geocoder();
    geocoder.addressSearch(address, function (result, status) {
      // 우편번호 서비스로 위도 경도 찾기
      data = { name: '카페 이름', latitude: result[0], longitude: result[1] };
      console.log(data);
      axios.post('/test')
      if (status === kakao.maps.services.Status.OK) {
        const coords = new kakao.maps.LatLng(result[0].y, result[0].x);
        console.log(coords);
      }
    });
  };

  return (
    <div style={{ display: 'flex', justifyContent: 'space-between' }}>
      {address}
      <button
        style={{
          background: 'lightgreen',
          border: 'none',
          borderRadius: '3px',
          padding: '5px',
        }}
        onClick={handleAddress.clickButton}
      >
        주소검색
      </button>

      {openPostcode && (
        <>
          <ModalBackdropStyle onClick={handleModal}>
            <DaumPostcode
              style={{
                position: 'absolute',
                width: '500px',
                top: '20%',
                left: '35%',
              }}
              onComplete={handleAddress.selectAddress} // 값을 선택할 경우 실행되는 이벤트
              autoClose={false} // 값을 선택할 경우 사용되는 DOM을 제거하여 자동 닫힘 설정
            />
          </ModalBackdropStyle>
        </>
      )}
    </div>
  );
};

export default AddressUploader;
