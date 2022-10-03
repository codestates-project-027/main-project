import { createSlice } from '@reduxjs/toolkit';

const initialState = {
  list:[],
  reviewId: 0,
  contents: '',
  createdAt:'',
  username:'',
};

//상세 목록
export const reviewSlice = createSlice({
  name: 'review',
  initialState,
  reducers: {
    getReview: (state, action) => {
      state.list = action.payload.list;
    },
    postReview: (state, action) => {
      state.reviewId = action.payload.reviewId;
      state.contents = action.payload.contents;
      state.createdAt = action.payload.createdAt;
      state.username = action.payload.username;
    },
    patchReview: (state, action) => {
      state.reviewId = action.payload.reviewId;
      state.contents = action.payload.contents;
      state.createdAt = action.payload.createdAt;
      state.username = action.payload.username;
    },
  },
});

export const { getReview, postReview, patchReview } =
reviewSlice.actions;
