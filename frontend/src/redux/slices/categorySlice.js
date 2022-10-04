import { createSlice } from '@reduxjs/toolkit';

const initialState = {
  list: [],
};

export const categorySlice = createSlice({
  name: 'category',
  initialState,
  reducers: {
    getCategory: (state, action) => {
      state.list = action.payload.list;
    },
  },
});

export const { getCategory } = categorySlice.actions;
