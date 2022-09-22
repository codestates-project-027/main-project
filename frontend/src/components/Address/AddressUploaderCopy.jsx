import DaumPostcode from 'react-daum-postcode';
import { useState } from 'react';
import { ModalBackdropStyle } from '../../styles/components/ModalStyle';

const AddressUploader = () => {
  const [openPostcode, setOpenPostcode] = useState(false);
  const [address, setAddress] = useState('');

  const handleAddress = {
    clickButton: () => {
      setOpenPostcode((current) => !current);
    },

    selectAddress: (data) => {
      setAddress(data.address);
      setOpenPostcode(false);
      console.log(address);
    },
  };

  const handleModal = () => {
    setOpenPostcode(false);
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
