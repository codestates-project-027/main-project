import { RegisterFailityForm } from '../../styles/components/FormStyle';
import { H2 } from '../Text/Head';
import { Input } from '../InputTextarea/FormInputs';
import { FacilityDescForm } from '../InputTextarea/FormTextarea';
import { TagSelectbar } from '../Bar/Selectbar';

export const RegisterFacility = () => {
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
        <div className="input--wrapper">사진넣는 컴포넌트</div>
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
          <Input label={'address'} />
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
        <div className="input--wrapper">위치등록 컴포넌트</div>
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
