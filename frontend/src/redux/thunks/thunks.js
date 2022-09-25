import MinimiClient from '../../api/Interceptor';
import { apiPath } from '../../api/AXIOS';
import { AXIOSCategory } from '../../api/AXIOS';

import axios from 'axios';


export const getCategoryThunk = () => async (dispatch) => {
  // const res = await MinimiClient.get(apiPath.API_GetCategory);
  // dispatch(getCategoryAction);
  const res = await axios.get('https://minimi-place.duckdns.org/category');
};

export const postCategoryThunk =
  ({ values }) =>
  async (dispacth) => {
    // dispacth(postCategoryAction);
    const res = await axios.post(
      'https://minimi-place.duckdns.org/category',
      values
    );
  };

export const patchCategoryThunk =
  ({ values }) =>
  async (dispatch) => {
    // dispatch(patchCategoryAction);
    const res = await axios.patch(
      `https://minimi-place.duckdns.org/category/${values.categoryCode}`,
      values
    );
  };
