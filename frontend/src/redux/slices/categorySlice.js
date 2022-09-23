import { createSlice } from '@reduxjs/toolkit';
import MinimiClient from '../../api/Interceptor';
import { apiPath } from '../../api/AXIOS';

const initialState = {
  categoryCode: '',
  categoryTitle: '',
  categoryStatus: '',
};

//actions
// export const GET_CATEGORY = 'GET_CATEGORY';
// export const getCategoryAction = () => {
//   return (dispatch,getState) => {
//       MinimiClient.get(apiPath.API_GetCategory)
//   }
// };

export const categorySlice = createSlice({
  name: 'category',
  initialState,
  reducers: {
    getCategory: (state, action) => {
      state.categoryCode = action.payload.categoryCode;
      state.categoryTitle = action.payload.categoryTitle;
      state.categoryStatus = action.payload.categoryStatus;
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
