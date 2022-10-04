import { createSlice } from '@reduxjs/toolkit';

const initialState = {
  id: 0,
  title: '',
  author: '',
};

export const testSlice = createSlice({
  name: 'test',
  initialState,
  reducers: {
    getTest: (state, action) => {
      state.id = action.payload.id;
      state.title = action.payload.title;
      state.author = action.payload.author;
    },
  },
});

export const { getTest } = testSlice.actions;
