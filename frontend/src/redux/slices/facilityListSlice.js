import { createSlice } from '@reduxjs/toolkit';

const initialState = {
  content: [],
};

//상세 목록
export const facilityListSlice = createSlice({
  name: 'facilities',
  initialState,
  reducers: {
    getFacilities: (state, action) => {
      state.content = action.payload.content;
    },
  },
});

export const { getFacilities } =
facilityListSlice.actions;
