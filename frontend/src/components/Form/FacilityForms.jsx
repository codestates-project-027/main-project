//api 구현하고 합칠 예정.. -> axios.post일 경우 시설 등록페이지 , axios.patch일 경우 시설 수정페이지

import { RegisterFailityForm } from '../../styles/components/FormStyle';
import { H2 } from '../Text/Head';
import { Input } from '../InputTextarea/FormInputs';
import { Textarea } from '../InputTextarea/FormTextarea';
import { TagSelectbar } from '../Bar/Selectbar';
import ImageUploader from '../Image/ImageUploader';
import AddressUploader from '../Address/AddressUploader';
import { BigBtn } from '../Button/Btns';
import styled from 'styled-components';
import { useSelector } from 'react-redux';



export const RegisterFacilityForm = () => {
  const categoryState = useSelector((state) => state.category);
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
          <Label htmlFor="Fname">이름</Label>
          <Input label={'Fname'} />
        </div>
        <div className="input--wrapper">
          <ImageUploader />
        </div>
        <div className="input--wrapper">
          <Label htmlFor="desc">설명</Label>
          <Textarea type="facility" />
        </div>
        <div className="input--wrapper">
          <Label htmlFor="address">주소</Label>
          <AddressWrapper>
            <AddressUploader />
            <Input placeholder={'상세주소 입력'} label={'address'} />
          </AddressWrapper>
        </div>
        <div className="input--wrapper">
          <Label htmlFor="webpage">web</Label>
          <Input label={'webpage'} />
        </div>
        <div className="input--wrapper">
          <Label htmlFor="phonenum">전화</Label>
          <Input label={'phonenum'} />
        </div>
        <div className="tags--wrapper">
          <Div>태그</Div>
          <TagSelectbar data={categoryState.list} />
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
          <Label htmlFor="Fname">이름</Label>
          <Input label={'Fname'} />
        </div>
        <div className="input--wrapper">
          <ImageUploader />
        </div>
        <div className="input--wrapper">
          <Label htmlFor="desc">설명</Label>
          <Textarea type="facility" />
        </div>
        <div className="input--wrapper">
          <Label htmlFor="address">주소</Label>
          <AddressWrapper>
            <AddressUploader />
            <Input placeholder={'상세주소 입력'} label={'address'} />
          </AddressWrapper>
        </div>
        <div className="input--wrapper">
          <Label htmlFor="webpage">web</Label>
          <Input label={'webpage'} />
        </div>
        <div className="input--wrapper">
          <Label htmlFor="phonenum">전화</Label>
          <Input label={'phonenum'} />
        </div>
        <div className="tags--wrapper">
          <Div>태그</Div>
          <TagSelectbar data={data} />
        </div>
        <div className="btn--wrapper">
          <BigBtn>시설 정보 변경</BigBtn>
        </div>
      </RegisterFailityForm>
    </>
  );
};

const Label = styled.label`
  margin-right: 15px;
`;

const AddressWrapper = styled.div`
  display: flex;
  flex-direction: column;
`;

const Div = styled.div`
  margin-right: 17px;
`;
