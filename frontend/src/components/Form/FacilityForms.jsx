//api 구현하고 합치기.. -> axios.post일 경우 시설 등록페이지 , axios.patch일 경우 시설 수정페이지

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
import { useState } from 'react';
import axiosInstance from '../../api/Interceptor';

export const RegisterFacilityForm = () => {
  const categoryState = useSelector((state) => state.category);
  const facilityState = useSelector((state) => state.facility);
  const [images, setImages] = useState([]);
  const imagesResolved = images.map((el) => el.file);
  const [tagsList, setTagsList] = useState([]);
  const [registerFac, setRegisterFac] = useState({
    facilityName: '',
    facilityPhotoList: [],
    facilityInfo: '',
    address2: '',
    website: '',
    phone: '',
    location: '',
    tags: [],
  });

  const {
    facilityName,
    facilityPhotoList,
    facilityInfo,
    address2,
    website,
    phone,
    location,
    tags,
  } = registerFac;

  const onChange = (e) => {
    setRegisterFac({
      ...registerFac,
      [e.target.name]: e.target.value,
    });
  };

  const postFacilityAXIOS = async () => {
    // const body = { //photoList가 모여있을 때
    //   facilityName,
    //   facilityPhotoList: images.map((el) => el.file),
    //   facilityInfo,
    //   address: `${facilityState.address} ${address2}`,
    //   website,
    //   phone,
    //   location: facilityState.location,
    //   tags: tagsList,
    // };
    const body = { //photoList 따로 둘 때
      facilityName,
      facilityPhoto: imagesResolved[0],
      facilityPhotoList: imagesResolved.slice(1),
      facilityInfo,
      address: `${facilityState.address} ${address2}`,
      website,
      phone,
      location: facilityState.location,
      tags: tagsList,
    };
    // const res = await axiosInstance.post(`/facility`, body);
    console.log(body)
  };

  const onSubmit = async () => {
    postFacilityAXIOS();
    // console.log(imagesResolved[0],imagesResolved.slice(1))
  };

  return (
    <>
      <RegisterFailityForm>
        <H2>시설 등록하기</H2>
        <div className="input--wrapper">
          <Label htmlFor="name">이름</Label>
          <Input
            name={'facilityName'}
            label={'name'}
            width="300px"
            value={facilityName}
            onChange={onChange}
          />
        </div>
        <div className="input--wrapper">
          <ImageUploader images={images} setImages={setImages} />
        </div>
        <div className="input--wrapper">
          <Label htmlFor="desc">설명</Label>
          <Textarea
            type="facility"
            registerFac={registerFac}
            setRegisterFac={setRegisterFac}
          />
        </div>
        <div className="input--wrapper">
          <Label htmlFor="address">주소</Label>
          <AddressWrapper>
            <AddressUploader facilityState={facilityState} />
            <Input
              placeholder={'상세주소 입력'}
              name="address2"
              label={'address'}
              onChange={onChange}
            />
          </AddressWrapper>
        </div>
        <div className="input--wrapper">
          <Label htmlFor="website">web</Label>
          <Input label={'website'} name="website" onChange={onChange} />
        </div>
        <div className="input--wrapper">
          <Label htmlFor="phone">전화</Label>
          <Input label={'phone'} name="phone" onChange={onChange} />
        </div>
        <div className="tags--wrapper">
          <Div>태그</Div>
          <TagSelectbar
            data={categoryState.list}
            tagsList={tagsList}
            setTagsList={setTagsList}
          />
        </div>
        <div className="btn--wrapper">
          <BigBtn onClick={onSubmit}>시설 등록</BigBtn>
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
