import { RegisterFailityForm } from '../../styles/components/FormStyle';
import { H2 } from '../Text/Head';
import { Input } from '../InputTextarea/FormInputs';
import { FacilityDescForm } from '../InputTextarea/FormTextarea';
import { TagSelectbar } from '../Bar/Selectbar';
import ImageUploader from '../../components/Image/ImageUploader';
import AddressUploader from '../../components/Address/AddressUploader';
import AddressUploaderCopy from '../../components/Address/AddressUploaderCopy';
import GoogleMap from '../../components/Address/GeoCodingHandler';

export const RegisterFacilityForm = () => {
  const data = [
    {
      categoryCode: '220811',
      categoryTitle: '헬스',
      categoryStatus: '활성',
    },
    {
      categoryCode: '220901',
      categoryTitle: '요가',
      categoryStatus: '비활성',
    },
  ];

  return (
    <>
      <RegisterFailityForm>
        <H2>시설 등록하기</H2>
        <div className="input--wrapper">
          <label style={{ marginRight: '15px' }} htmlFor="Fname">
            이름
          </label>
          <Input label={'Fname'} />
        </div>
        <div className="input--wrapper">
          <ImageUploader />
        </div>
        <div className="input--wrapper">
          <label style={{ marginRight: '15px' }} htmlFor="desc">
            설명
          </label>
          <FacilityDescForm />
        </div>
        <div className="input--wrapper">
          <label style={{ marginRight: '15px' }} htmlFor="address">
            주소
          </label>
          <div style={{ display: 'flex', flexDirection: 'column' }}>
            <AddressUploader />
            <Input placeholder={'상세주소 입력'} label={'address'} />
          </div>
        </div>
        <div className="input--wrapper">
          <label style={{ marginRight: '15px' }} htmlFor="webpage">
            web
          </label>
          <Input label={'webpage'} />
        </div>
        <div className="input--wrapper">
          <label style={{ marginRight: '15px' }} htmlFor="phonenum">
            전화
          </label>
          <Input label={'phonenum'} />
        </div>
        {/* <div className="input--wrapper">
          위치등록 컴포넌트
          <GoogleMap currentAddress/>
        </div> */}
        <div className="input--wrapper">
          <TagSelectbar data={data} />
        </div>
      </RegisterFailityForm>
    </>
  );
};

export const EditFacility = () => {
  return (
    <>
      <div>시설수정 form</div>
    </>
  );
};
