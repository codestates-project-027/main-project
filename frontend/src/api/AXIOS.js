import axios from 'axios';
import MinimiClient from './Interceptor';

export const apiPath = {
  getcategory: '/category',
  POST_Category: '/category',
};

export const AXIOSCategory = {
  // GET: async () => {
  //   const res = await MinimiClient.get(apiPath.getcategory);
  //   console.log(res);
  // },
  GET: async () => {
    const res = await axios.get('https://minimi-place.duckdns.org/category');
  
  },
};
