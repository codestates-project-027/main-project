//api 구현하고 합치기.. -> axios.post일 경우 시설 등록페이지 , axios.patch일 경우 시설 수정페이지
//

import { FacilityFormStyle } from '../../styles/components/FormStyle';
import { H2 } from '../Text/Head';
import { Input } from '../InputTextarea/FormInputs';
import { Textarea } from '../InputTextarea/FormTextarea';
import { TagSelectbar } from '../Bar/Selectbar';
import ImageUploader from '../Image/ImageUploader';

import AddressUploader from '../Address/AddressUploader';
import { BigBtn } from '../Button/Btns';
import styled from 'styled-components';
import { useDispatch, useSelector } from 'react-redux';
import { useState, useEffect } from 'react';
import axiosInstance from '../../api/Interceptor';
import { postFacility, patchFacility } from '../../redux/slices/facilitySlice';
import { useNavigate, useParams } from 'react-router-dom';

export const FacilityForm = ({ mode }) => {
  const patchFacilityState = useSelector((state) => state.facility);
  const dispatch = useDispatch();
  const navigate = useNavigate();
  const { id } = useParams();
  const categoryState = useSelector((state) => state.category);
  const facilityState = useSelector((state) => state.facility);
  const [images, setImages] = useState([]);
  const [tagsList, setTagsList] = useState([]);
  const [registerFac, setRegisterFac] = useState(
    mode === 'edit'
      ? {
          facilityName: facilityState.facilityName,
          facilityPhotoList: [], //넣기
          facilityInfo: facilityState.facilityInfo,
          address: facilityState.address.split(' ').slice(0, 4).join(' '),
          address2: facilityState.address.split(' ').slice(4),
          website: facilityState.website,
          phone: facilityState.phone,
          tags: facilityState.categoryList, //넣기
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

  console.log(patchFacilityState);
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
      // categoryList: tagsList,
    };

    formData.append(
      'request',
      new Blob([JSON.stringify(dataSet)], { type: 'application/json' })
    );

    const file = images.length === 0 ? null : images.map((el) => el.file);
    formData.append('file', new Blob([file])); //사진을 굳이 안넣으면 원본 보존/ 넣으면 변경됨...
    //사진을 넣으면 413 에러가 난다.

    try {
      //edit page 접근하는 방법 :: facility 상세보기 -> 해당 글쓴이만 수정가능하게..
      await axiosInstance
        .patch(`/facility/76`, formData, {
          headers: {
            'Content-Type': 'multipart/form-data',
          },
        })
        .then((res) => console.log('edit status:', res.status));
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
    //navigate :: facilities
  };

  const onSubmitEdit = async () => {
    EditFacilityAXIOS();
    dispatch(
      patchFacility({
        address: '',
        location: '',
      })
    );
    //navigate :: facility
  };

  const onDelete = async () => {
    DeleteFacilityAXIOS();
    navigate('/facility');
  };

  useEffect(() => {}, []);

  return (
    //edit mode일 때,... facility page에 보이는 부분 -> state에 저장한거 가져와서 보여주기.(localstorage)
    //주소랑 태그는 꼭 입력해야 갱신됨 -> localstorage로 처리하기
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
          <ImageUploader images={images} setImages={setImages} />
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
              <AddressUploader
                value={registerFac.address}
                facilityState={facilityState}
                mode="edit"
              />
            ) : (
              <AddressUploader
                value={registerFac.address}
                facilityState={facilityState}
              />
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
          <TagSelectbar
            data={categoryState.list.slice(1)}
            tagsList={mode==='edit'? facilityState.categoryList:tagsList}
            setTagsList={setTagsList}
          />
        </div>
        <div className="btn--wrapper">
          <BigBtn
            marginRight="40px"
            onClick={mode === 'edit' ? onSubmitEdit : onSubmit}
          >
            {mode === 'edit' ? '시설 변경' : '시설 등록'}
          </BigBtn>

          <BigBtn
            color="red"
            hoverBg="black"
            onClick={mode === 'edit' ? onDelete : ''}
          >
            {mode === 'edit' ? '삭제' : ''}
          </BigBtn>
        </div>
      </FacilityFormStyle>
    </>
  );
};

// export const EditFacilityForm = () => {
//   const data = [
//     {
//       categoryCode: '220811',
//       categoryTitle: '헬스',
//       categoryStatus: '활성',
//     },
//     {
//       categoryCode: '220901',
//       categoryTitle: '요가',
//       categoryStatus: '비활성',
//     },
//   ];

//   return (
//     //로컬스토리지에서 정보 가져오기 -> 수정 -> api로 수정요청
//     <>
//       <RegisterFailityForm>
//         <H2>시설 정보 변경하기</H2>
//         <div className="input--wrapper">
//           <Label htmlFor="Fname">이름</Label>
//           <Input label={'Fname'} />
//         </div>
//         <div className="input--wrapper">
//           <ImageUploader />
//         </div>
//         <div className="input--wrapper">
//           <Label htmlFor="desc">설명</Label>
//           <Textarea type="facility" />
//         </div>
//         <div className="input--wrapper">
//           <Label htmlFor="address">주소</Label>
//           <AddressWrapper>
//             <AddressUploader />
//             <Input placeholder={'상세주소 입력'} label={'address'} />
//           </AddressWrapper>
//         </div>
//         <div className="input--wrapper">
//           <Label htmlFor="webpage">web</Label>
//           <Input label={'webpage'} />
//         </div>
//         <div className="input--wrapper">
//           <Label htmlFor="phonenum">전화</Label>
//           <Input label={'phonenum'} />
//         </div>
//         <div className="tags--wrapper">
//           <Div>태그</Div>
//           <TagSelectbar data={data} />
//         </div>
//         <div className="btn--wrapper">
//           <BigBtn>시설 정보 변경</BigBtn>
//         </div>
//       </RegisterFailityForm>
//     </>
//   );
// };

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
