import MinimiClient from './Interceptor';

export const apiPath = {
  GET_category: '/category',
  POST_category: '/category',
};


export const AXIOSCategory = {
  GET: async () => {
    const { data } = await MinimiClient.get(apiPath.API_GetCategory);
    return data
  },
};
