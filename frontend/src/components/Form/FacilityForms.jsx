import styled from 'styled-components';
import { useState } from 'react';
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

export const FacilityForm = ({ mode, fin, setFin }) => {
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
          address: '',
          address2: '',
          website: '',
          phone: '',
          location: '',
          tags: [],
        }
  );

  const {
    facilityName,
    // facilityPhotoList,
    facilityInfo,
    address2,
    website,
    phone,
    // location,
    // tags,
  } = registerFac;

  const onChange = (e) => {
    setRegisterFac({
      ...registerFac,
      [e.target.name]: e.target.value,
    });
  };

  //make form utils
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

  const file =
    typeof images[0] === 'string'
      ? images.length===0? null : ''
      : images.length === 0
      ? null
      : images.map((el) => el.file);

  formData.append(
    'request',
    new Blob([JSON.stringify(dataSet)], { type: 'application/json' })
  );

  if (file !== null) {
    for (let i = 0; i < file.length; i++) {
      formData.append('file', !file ? null : new Blob(file.slice(i, i + 1)));
    }
  }

  //axios
  const postFacilityAXIOS = async () => {
    try {
      await axiosInstance.post(`/facility`, formData, {
        headers: {
          'Content-Type': 'multipart/form-data',
        },
      });
      // .then((res) => console.log('status:', res.status));
      dispatch(
        postFacility({
          address: '',
          location: '',
        })
      );
      setFin(!fin);
    } catch (err) {
      // console.log(err.response);
    }
    // console.log('dataSet:', dataSet, file);
  };

  const postHandler = () => {
    if (
      dataSet.facilityName === '' ||
      tagsList.length === 0 ||
      !dataSet.address
    ) {
      alert(`?????? ??????, ??????, ??????????????? ?????? ???????????????.`);
    } else onSubmit();
  };

  // console.log('data.add', dataSet.address);
  // console.log('images', images);
  const editHandler = () => {
    if (
      dataSet.facilityName === '' ||
      tagsList.length === 0 ||
      dataSet.address.length === 2
    ) {
      alert(`?????? ??????, ??????, ??????????????? ?????? ???????????????.`);
    } else onSubmitEdit();
  };

  //?????? action?????? ?????? ..... ????????? ????????????.. ?????? form ????????? ????????????..

  const EditFacilityAXIOS = async () => {
    //TO DO : img?????? -> file??? ?????? ?????? //????????? ?????? ???????????? ?????? ??????, ????????? ?????????

    try {
      //edit page ???????????? ?????? :: facility ???????????? -> ?????? ???????????? ??????????????????..
      await axiosInstance.patch(`/facility/${id}`, formData, {
        headers: {
          'Content-Type': 'multipart/form-data',
        },
      });
      // .then((res) => console.log('edit data:', res.data));
      dispatch(
        patchFacility({
          address: '',
          location: '',
        })
      );
      setFin(!fin);
    } catch (err) {
      // console.log(err.response);
    }
    // console.log('edit dataSet:', dataSet, images);
  };

  const DeleteFacilityAXIOS = async () => {
    try {
      //edit page ???????????? ?????? :: facility ???????????? -> ?????? ???????????? ??????????????????..
      await axiosInstance.delete(`/facility/` + id);
      // .then((res) => console.log('edit status:', res.status));
      setFin(!fin);
    } catch (err) {
      // console.log(err.response);
    }
  };

  const onSubmit = async () => {
    postFacilityAXIOS();
    navigate('/facility');
  };

  const onSubmitEdit = async () => {
    EditFacilityAXIOS();
    navigate(`/facility/${id}`);
  };

  const onDelete = async () => {
    DeleteFacilityAXIOS();
    navigate('/facility');
  };

  return (
    <>
      <FacilityFormStyle>
        {/* {console.log(typeof images[0])} */}
        <H2>{mode === 'edit' ? '?????? ????????????' : '?????? ????????????'}</H2>
        <div className="input--wrapper">
          <Label htmlFor="name">??????</Label>
          <Input
            placeholder={'?????? ??????'}
            required
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
          <Label htmlFor="desc">??????</Label>
          <Textarea
            placeholder={'?????? ??????'}
            required
            mode="edit"
            type="facility"
            value={facilityInfo}
            registerFac={registerFac}
            setRegisterFac={setRegisterFac}
          />
        </div>
        <div className="input--wrapper">
          <Label htmlFor="address">??????</Label>
          <AddressWrapper>
            {mode === 'edit' ? (
              <AddressUploader facilityState={facilityState} mode={'edit'} />
            ) : (
              <AddressUploader facilityState={facilityState} />
            )}

            <Input
              placeholder={'???????????? ??????'}
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
            placeholder={'website'}
            label={'website'}
            name="website"
            value={website}
            onChange={onChange}
          />
        </div>
        <div className="input--wrapper">
          <Label htmlFor="phone">??????</Label>
          <Input
            placeholder={'phone'}
            label={'phone'}
            name="phone"
            value={phone}
            onChange={onChange}
          />
        </div>
        <div className="tags--wrapper">
          <Div>??????</Div>
          {mode === 'edit' ? (
            <TagSelectbar
              mode="edit"
              data={categoryState.list.slice(2)}
              tagsList={tagsList}
              setTagsList={setTagsList}
            />
          ) : (
            <TagSelectbar
              data={categoryState.list.slice(2)}
              tagsList={tagsList}
              setTagsList={setTagsList}
            />
          )}
        </div>
        <div className="btn--wrapper">
          <BigBtn
            type="submit"
            marginRight="40px"
            onClick={() => {
              mode === 'edit' ? editHandler() : postHandler();
            }}
          >
            {mode === 'edit' ? '?????? ??????' : '?????? ??????'}
          </BigBtn>
          {mode === 'edit' ? (
            <BigBtn
              type="submit"
              color="red"
              hoverBg="black"
              onClick={mode === 'edit' ? onDelete : ''}
            >
              ??????
            </BigBtn>
          ) : null}
        </div>
      </FacilityFormStyle>
    </>
  );
};

const Label = styled.label`
  margin-right: 15px;
  @media screen and (max-width: 790px) {
    display: none;
    ::placeholder {
    }
  }
`;

const AddressWrapper = styled.div`
  display: flex;
  flex-direction: column;
`;

const Div = styled.div`
  margin-right: 17px;
`;
