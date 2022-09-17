import axios from 'axios';

export default axios.create({
  testURL: `http://localhost:8080`,
  baseURL: `https://minimi-place.duckdns.org`,
});

//use
//import api from ''
//await api.post('path',body)
