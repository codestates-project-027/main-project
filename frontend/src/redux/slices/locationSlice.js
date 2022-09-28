import { createSlice } from '@reduxjs/toolkit';

const initialState = {
  currentLocation: { latitude: 0, longitude: 0 },
};

//상세 목록
export const locationSlice = createSlice({
  name: 'location',
  initialState,
  reducers: {
    getLocation: (state, action) => {
      state.currentLocation = action.payload.currentLocation;
    },
  },
});

export const { getLocation } = locationSlice.actions;
