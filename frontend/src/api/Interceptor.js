import axios from 'axios';

//axios intercepter
const MinimiClient = axios.create({
  baseURL: `https://minimi-place.duckdns.org`,
  timeout: 1000,
});

//Request interceptor
MinimiClient.interceptors.request.use(
  function (config) {
    config.headers['Content-Type'] = 'application/json; charset=utf-8';
    // config.headers['Authorization'] = `Bearer 토큰값`; ->수정하기
    return config;
  },
  function (error) {
    console.log(error);
    return Promise.reject(error);
  }
);

//Response interceptor
MinimiClient.interceptors.response.use(
  function (response) {
    return response.data.data;
  },
  function (error) {
    if (error.status === 404) {
      console.log(`404에러`);
    }
    return Promise.reject(error);
  }
);

export default MinimiClient;
