import { configureStore } from '@reduxjs/toolkit';
import communityReducer from '../CommunitySlice/CommunitySlice';

export const store = configureStore({
  reducer: {
    postings: communityReducer,
  },
});
