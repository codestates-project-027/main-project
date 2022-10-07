import DaumPostcode from 'react-daum-postcode';
import { useState, useEffect } from 'react';
import { ModalBackdropStyle } from '../../styles/components/Modalstyle';
import { BasicBtn } from '../Button/Btns';
import styled from 'styled-components';
import { useDispatch } from 'react-redux';
import { postFacility } from '../../redux/slices/facilitySlice';

const { kakao } = window;

const AddressUploader = ({ facilityState, value, mode }) => {
  // const patchFacilityState = useSelector((state) => state.facility);
  const dispatch = useDispatch();

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
      //
      const geocoder = new kakao.maps.services.Geocoder(); //axios call -> action 내부에서 써야함

      const callback = function (result, status) {
        if (status === kakao.maps.services.Status.OK) {
          setCoord({
            lat: result[0].road_address.y,
            lng: result[0].road_address.x,
          });
          dispatch(
            postFacility({
              address: address,
              location: `${result[0].road_address.y.slice(
                0,
                -7
              )}, ${result[0].road_address.x.slice(0, -6)}`,
            })
          );
        }
      };
      if (address) {
        geocoder.addressSearch(address, callback);
      }
    };
    geoCoding();
  }, [address]);

  return (
    <Div>
      {mode === 'edit' ? facilityState.address : address}
      <BasicBtn backGround={'var(--main-yellow)'} onClick={handleAddress.clickButton}>
        주소검색
      </BasicBtn>

      {openPostcode && (
        <>
          <ModalBackdropStyle
            onClick={() => {
              setOpenPostcode(false);
            }}
          >
            <DaumPostcodeWrapper>
              <DaumPostcode
                onComplete={handleAddress.selectAddress} // 값을 선택할 경우 실행되는 이벤트
                autoClose={false} // 값을 선택할 경우 사용되는 DOM을 제거하여 자동 닫힘 설정
              />
            </DaumPostcodeWrapper>
          </ModalBackdropStyle>
        </>
      )}
    </Div>
  );
};

export default AddressUploader;

const Div = styled.div`
  display: flex;
  justify-content: space-between;
`;

const DaumPostcodeWrapper = styled.div`
  position: absolute;
  width: 500px;
  top: 20%;
  left: 35%;
`;
