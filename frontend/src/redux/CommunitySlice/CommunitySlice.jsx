//slice가 하는일 : 리듀서(어떻게 수정할건지) 만드는 걸 도와줌

import { createSlice } from '@reduxjs/toolkit';

const initialState = [];

export const communitySlice = createSlice({
  name: 'community',
  initialState,
  reducers: {
    WritingPost: (state, action) => {
      state.push(action.payload);
    },
  },
});

export const { WritingPost } = communitySlice.actions;
