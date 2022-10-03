import axiosInstance from '../../api/Interceptor';
import { createAsyncThunk } from '@reduxjs/toolkit';
import axios from 'axios';

//EX
export const getThunk = createAsyncThunk('GET_TEST', async () => {
  const res = await axios.get('http://localhost:8080/home');
  return res.data;
});
