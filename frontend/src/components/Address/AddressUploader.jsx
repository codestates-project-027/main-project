import DaumPostcode from 'react-daum-postcode';
import { useState, useEffect } from 'react';
import { ModalBackdropStyle } from '../../styles/components/Modalstyle';
import { BasicBtn } from '../Button/Btns';

const { kakao } = window;

const AddressUploader = () => {
  const [openPostcode, setOpenPostcode] = useState(false);
  const [address, setAddress] = useState('');
  const [coord, setCoord] = useState({});

  const handleAddress = {
    clickButton: () => {
      setOpenPostcode((current) => !current);
    },

    selectAddress: (data) => {
      setAddress(data.address);
      setOpenPostcode(false);
    },
  };

  useEffect(() => {
    const geoCoding = () => {
      const geocoder = new kakao.maps.services.Geocoder();

      const callback = function (result, status) {
        if (status === kakao.maps.services.Status.OK) {
          setCoord({
            lat: result[0].road_address.x,
            lng: result[0].road_address.y,
          });
        }
      };
      if (address) {
        geocoder.addressSearch(address, callback);
      }
    };
    geoCoding();
  }, [address]);

  return (
    <div style={{ display: 'flex', justifyContent: 'space-between' }}>
      {address}
      {console.log(coord)}
      <BasicBtn backGround={'lightgreen'} onClick={handleAddress.clickButton}>
        주소검색
      </BasicBtn>

      {openPostcode && (
        <>
          <ModalBackdropStyle
            onClick={() => {
              setOpenPostcode(false);
            }}
          >
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
