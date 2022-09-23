import MinimiClient from './Interceptor';
import { useState } from 'react';

export const apiPath = {
  API_GetCategory: '/category',
  API_PostCategory: '/category',
};

//states

// export const getCategory = async () => {
//   const response = await MinimiClient.get(apiPath.API_GetCategory);
//   console.log(response);
// };

export const AXIOSCategory = {
  GET: async () => {
    const { data } = await MinimiClient.get(apiPath.API_GetCategory);
  },
};
