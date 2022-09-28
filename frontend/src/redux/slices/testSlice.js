import { createSlice } from '@reduxjs/toolkit';

const initialState = {
    facilityName: '',
    facilityPhotoList: [],
    facilityInfo: '',
    address: '',
    website: '',
    phone: '',
    starRate: 0,
    location: '',
    categoryList: [],
    facilityStatus: '',
  };

export const testSlice = createSlice({
  name: 'test',
  initialState,
  reducers: {
    getCategory: (state, action) => {
      state.list = action.payload.list;
    },
    postCategory: (state, action) => {
      state.categoryCode = action.payload.categoryCode;
      state.categoryTitle = action.payload.categoryTitle;
      state.categoryStatus = action.payload.categoryStatus;
    },
    patchCategory: (state, action) => {
      state.categoryTitle = action.payload.categoryTitle;
      state.categoryStatus = action.payload.categoryStatus;
    },
  },
});

export const { getCategory } = testSlice.actions;
