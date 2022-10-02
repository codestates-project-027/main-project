import styled from 'styled-components';
import { useState, useEffect } from 'react';
import { useDispatch, useSelector } from 'react-redux';
import { useNavigate, useParams } from 'react-router-dom';

import { FacilityFormStyle } from '../../styles/components/FormStyle';
import { H2 } from '../Text/Head';
import { BigBtn } from '../Button/Btns';
import { Input } from '../InputTextarea/FormInputs';
import { Textarea } from '../InputTextarea/FormTextarea';
import { TagSelectbar } from '../Bar/Selectbar';
import ImageUploader from '../Image/ImageUploader';
import AddressUploader from '../Address/AddressUploader';
import axiosInstance from '../../api/Interceptor';
import { postFacility, patchFacility } from '../../redux/slices/facilitySlice';

export const FacilityForm = ({ mode }) => {
  const patchFacilityState = useSelector((state) => state.facility);
  const dispatch = useDispatch();
  const navigate = useNavigate();
  const { id } = useParams();
  const categoryState = useSelector((state) => state.category);
  const facilityState = useSelector((state) => state.facility);
  const [images, setImages] = useState(
    mode === 'edit' ? facilityState.facilityPhotoList : []
  );
  const [tagsList, setTagsList] = useState(
    mode === 'edit' ? facilityState.categoryList : []
  );

  const [registerFac, setRegisterFac] = useState(
    mode === 'edit'
      ? {
          facilityName: facilityState.facilityName,
          facilityPhotoList: facilityState.facilityPhotoList,
          facilityInfo: facilityState.facilityInfo,
          address: facilityState.address,
          address2: '',
          website: facilityState.website,
          phone: facilityState.phone,
          tags: tagsList, 
        }
      : {
          facilityName: '',
          facilityPhotoList: [],
          facilityInfo: '',
          address2: '',
          website: '',
          phone: '',
          location: '',
          tags: [],
        }
  );

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
    const formData = new FormData();
    const dataSet = {
      facilityName,
      facilityInfo,
      address: `${facilityState.address} ${address2}`,
      website,
      phone,
      location: facilityState.location,
      categoryList: tagsList,
    };

    const file = images.length === 0 ? null : images.map((el) => el.file);

    formData.append(
      'request',
      new Blob([JSON.stringify(dataSet)], { type: 'application/json' })
    );

    formData.append('file', new Blob(file));

    try {
      await axiosInstance
        .post(`/facility`, formData, {
          headers: {
            'Content-Type': 'multipart/form-data',
          },
        })
        .then((res) => console.log('status:', res.status));
    } catch (err) {
      console.log(err.response);
    }
    console.log('dataSet:', dataSet, file);
  };

  //이거 action으로 빼면 ..... 재활용 가능할듯.. 일단 form 부분만 해결하자..

  const EditFacilityAXIOS = async () => {
    const formData = new FormData();
    const dataSet = {
      facilityName,
      facilityInfo,
      address: `${facilityState.address} ${address2}`,
      website,
      phone,
      location: facilityState.location,
      categoryList: tagsList,
    };

    //변경하기 -> 사진 안보임. 새로고침해야 보임..
    //한장만 업로드 가능,,.. 
    formData.append(
      'request',
      new Blob([JSON.stringify(dataSet)], { type: 'application/json' })
    );
    const file = images.length === 0 ? null : images.map((el) => el.file);
    formData.append('file', new Blob(file));

    // formData.append('file', new Blob([file]));

    //사진을 굳이 안넣으면 원본 보존/ 넣으면 변경됨...

    try {
      //edit page 접근하는 방법 :: facility 상세보기 -> 해당 글쓴이만 수정가능하게..
      await axiosInstance
        .patch(`/facility/${id}`, formData, {
          headers: {
            'Content-Type': 'multipart/form-data',
          },
        })

        .then((res) => console.log('edit data:', res.data));
    } catch (err) {
      console.log(err.response);
    }
    console.log('edit dataSet:', dataSet, images);
  };

  const DeleteFacilityAXIOS = async () => {
    try {
      //edit page 접근하는 방법 :: facility 상세보기 -> 해당 글쓴이만 수정가능하게..
      await axiosInstance
        .delete(`/facility/` + id)
        .then((res) => console.log('edit status:', res.status));
    } catch (err) {
      console.log(err.response);
    }
  };

  const onSubmit = async () => {
    postFacilityAXIOS();
    dispatch(
      postFacility({
        address: '',
        location: '',
      })
    );
    navigate('/facility');
  };

  const onSubmitEdit = async () => {
    EditFacilityAXIOS();
    dispatch(
      patchFacility({
        address: '',
        location: '',
      })
    );
    navigate(`/facility/${id}`);
  };

  const onDelete = async () => {
    DeleteFacilityAXIOS();
    navigate('/facility');
  };

  useEffect(() => {}, []);

  return (
    <>
      <FacilityFormStyle>
        <H2>{mode === 'edit' ? '시설 변경하기' : '시설 등록하기'}</H2>
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
          {mode === 'edit' ? (
            <ImageUploader mode="edit" images={images} setImages={setImages} />
          ) : (
            <ImageUploader
              registerFac={registerFac}
              setRegisterFac={setRegisterFac}
              images={images}
              setImages={setImages}
            />
          )}
        </div>
        <div className="input--wrapper">
          <Label htmlFor="desc">설명</Label>
          <Textarea
            mode="edit"
            type="facility"
            value={facilityInfo}
            registerFac={registerFac}
            setRegisterFac={setRegisterFac}
          />
        </div>
        <div className="input--wrapper">
          <Label htmlFor="address">주소</Label>
          <AddressWrapper>
            {mode === 'edit' ? (
              <AddressUploader facilityState={facilityState} mode={'edit'} />
            ) : (
              <AddressUploader facilityState={facilityState} />
            )}

            <Input
              placeholder={'상세주소 입력'}
              name="address2"
              label={'address'}
              value={address2}
              onChange={onChange}
            />
          </AddressWrapper>
        </div>
        <div className="input--wrapper">
          <Label htmlFor="website">web</Label>
          <Input
            label={'website'}
            name="website"
            value={website}
            onChange={onChange}
          />
        </div>
        <div className="input--wrapper">
          <Label htmlFor="phone">전화</Label>
          <Input
            label={'phone'}
            name="phone"
            value={phone}
            onChange={onChange}
          />
        </div>
        <div className="tags--wrapper">
          <Div>태그</Div>
          {mode === 'edit' ? (
            <TagSelectbar
              mode="edit"
              data={categoryState.list.slice(1)}
              tagsList={tagsList}
              setTagsList={setTagsList}
            />
          ) : (
            <TagSelectbar
              data={categoryState.list.slice(1)}
              tagsList={tagsList}
              setTagsList={setTagsList}
            />
          )}
        </div>
        <div className="btn--wrapper">
          <BigBtn
            marginRight="40px"
            onClick={mode === 'edit' ? onSubmitEdit : onSubmit}
          >
            {mode === 'edit' ? '시설 변경' : '시설 등록'}
          </BigBtn>
          {mode === 'edit' ? (
            <BigBtn
              color="red"
              hoverBg="black"
              onClick={mode === 'edit' ? onDelete : ''}
            >
              삭제
            </BigBtn>
          ) : null}
        </div>
      </FacilityFormStyle>
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
