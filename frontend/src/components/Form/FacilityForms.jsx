import { RegisterFailityForm } from '../../styles/components/FormStyle';
import { H2 } from '../Text/Head';
import { Input } from '../InputTextarea/FormInputs';
import { FacilityDescForm } from '../InputTextarea/FormTextarea';
import { TagSelectbar } from '../Bar/Selectbar';
import ImageUploader from '../Image/ImageUploader';
import AddressUploader from '../Address/AddressUploader';
import { BigBtn } from '../Button/Btns';

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
        <div className="tags--wrapper">
          <div style={{ marginRight: '20px' }}>태그</div>
          <TagSelectbar data={data} />
        </div>
        <div className="btn--wrapper">
          <BigBtn>시설 등록</BigBtn>
        </div>
      </RegisterFailityForm>
    </>
  );
};

export const EditFacilityForm = () => {
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
    //로컬스토리지에서 정보 가져오기 -> 수정 -> api로 수정요청
    <>
      <RegisterFailityForm>
        <H2>시설 정보 변경하기</H2>
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
        <div className="tags--wrapper">
          <div style={{ marginRight: '20px' }}>태그</div>
          <TagSelectbar data={data} />
        </div>
        <div className="btn--wrapper">
        <BigBtn>시설 정보 변경</BigBtn>
        </div>
      </RegisterFailityForm>
    </>
  );
};
