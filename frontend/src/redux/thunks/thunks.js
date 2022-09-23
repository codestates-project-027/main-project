import MinimiClient from '../../api/Interceptor';
import { apiPath } from '../../api/AXIOS';
import { AXIOSCategory } from '../../api/AXIOS';
import { GET_CATEGORY } from '../slices/categorySlice';


export const getCategoryThunk = () => async (dispatch) => {
  const response = await MinimiClient.get(apiPath.API_GetCategory);
  dispatch({
    type: GET_CATEGORY,
    payload: response.data,
  });
};
