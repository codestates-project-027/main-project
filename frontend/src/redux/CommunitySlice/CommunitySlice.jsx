//slice가 하는일 : 리듀서(어떻게 수정할건지) 만드는 걸 도와줌

import { createSlice } from '@reduxjs/toolkit';

const initialState = [
  { id: '1', title: '플로깅 하실분', contents: '저랑 같이 해주세요' },
  { id: '2', title: '커피 맛있다', contents: '투샷은 먹어야...' },
];

export const communitySlice = createSlice({
  name: 'community',
  initialState,
  reducers: {
    AddPost: (state, action) => {
      state.push(action.payload);
    },
    EditPost: (state, action) => {
      const { id, title, contents } = action.payload;
      const existingPost = state.find((post) => post.id === id);
      if (existingPost) {
        existingPost.title = title;
        existingPost.contents = contents;
      }
    },
    DeletePost: (state, action) => {
      const { id } = action.payload;
      const existingPost = state.find((post) => post.id === id);
      if (existingPost) {
        return state.filter((post) => post.id !== id);
      }
    },
  },
});

export const { AddPost, EditPost, DeletePost } = communitySlice.actions;
