import { createSlice } from '@reduxjs/toolkit';

const initialState = {
  facilityName: '',
  facilityPhotoList: [],
  facilityInfo: '',
  address:'',
  website: '',
  phone: '',
  starRate: 0,
  location: '',
  categoryList: [],
  facilityStatus: '',
};

//상세 목록
export const facilitySlice = createSlice({
  name: 'facility',
  initialState,
  reducers: {
    getFacility: (state, action) => {
      state.facilityName = action.payload.facilityName;
      state.facilityPhotoList = action.payload.facilityPhotoList;
      state.facilityInfo = action.payload.facilityInfo;
      state.address = action.payload.address;
      state.website = action.payload.website;
      state.phone = action.payload.phone;
      state.starRate = action.payload.starRate;
      state.location = action.payload.location;
      state.categoryList = action.payload.categoryList;
      state.facilityStatus = action.payload.facilityStatus;
      //리뷰 부분 -> 아직임.
    },
    postFacility: (state, action) => {
      state.facilityName = action.payload.facilityName;
      state.facilityPhotoList = action.payload.facilityPhotoList;
      state.facilityInfo = action.payload.facilityInfo;
      state.address = action.payload.address;
      state.website = action.payload.website;
      state.phone = action.payload.phone;
      state.location = action.payload.location;
      state.categoryList = action.payload.categoryList;
    },
    patchFacility: (state, action) => {
      state.facilityName = action.payload.facilityName;
      state.facilityPhotoList = action.payload.facilityPhotoList;
      state.facilityInfo = action.payload.facilityInfo;
      state.address = action.payload.address;
      state.website = action.payload.website;
      state.phone = action.payload.phone;
      state.location = action.payload.location;
      state.categoryList = action.payload.categoryList;
    },
  },
});

export const { getFacility, postFacility, patchFacility } =
  facilitySlice.actions;
