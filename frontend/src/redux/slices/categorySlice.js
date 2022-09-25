import { createSlice } from '@reduxjs/toolkit';

const initialState = {
  list: [],
  categoryCode: '',
  categoryTitle: '',
  categoryStatus: '',
};

export const categorySlice = createSlice({
  name: 'category',
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

export const { getCategory } = categorySlice.actions;
