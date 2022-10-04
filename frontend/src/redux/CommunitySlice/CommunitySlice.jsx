//slice가 하는일 : 리듀서(어떻게 수정할건지) 만드는 걸 도와줌

import { createSlice } from '@reduxjs/toolkit';

const initialState = [];

export const communitySlice = createSlice({
  name: 'community',
  initialState,
  reducers: {
    AddPost: (state, action) => {
      state.push(action.payload);
    },
    editUser: (state, action) => {
      const { id, title, contents } = action.payload;
      const existingPost = state.find((post) => post.id === id);
      if (existingPost) {
        existingPost.title = title;
        existingPost.contents = contents;
      }
    },
  },
});

export const { AddPost, editPost } = communitySlice.actions;
