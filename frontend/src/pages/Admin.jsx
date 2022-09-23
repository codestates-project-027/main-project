// 기능 구현 후 정리

import { AdminGlobal } from '../styles/globalStyle/PageGlobalStyle';
import { ReadCategoryForm } from '../components/Form/CategoryForms';
import { useSelector, useDispatch } from 'react-redux';
import { useParams } from 'react-router-dom';
import { useEffect, useState } from 'react';
import AXIOSCategory from '../api/AXIOS';
import { readCategory } from '../redux/slices/categorySlice';
import axios from 'axios';
import MinimiClient from '../api/Interceptor';

//쓰기 : axios interceptor, redux-persist, redux-toolkit, redux-thunks, formik
//READ: 현재 카테고리 목록: Code, Title, Status별 (table)
//POST: 카테고리 생성 form : Code, Title, Status 입력
//PATCH : 카테고리 수정 form : Title, Status

const AdminPage = () => {
  const categoryState = useSelector((state) => state.categorySlice);
  const dispatch = useDispatch();
  const params = useParams();
  const [category, setCategory] = useState({});

  const data = [
    {
      categoryCode: '220811',
      categoryTitle: '헬스',
      categoryStatus: 'ACTIVE',
    },
    {
      categoryCode: '220901',
      categoryTitle: '요가',
      categoryStatus: 'INACTIVE',
    },
  ];

  //reducer

  const GET_CATEGORY = 'GET_CATEGORY';
  const POST_CATEGORY = 'POST_CATEGORY';
  const PATCH_CATEGORY = 'PATCH_CATEGORY';

  // action creator
  const getCategoryAction = (response) => {
    return {
      type: GET_CATEGORY,
      payload: response,
    };
  };

  const postCategoryAction = (response) => {
    return {
      type: POST_CATEGORY,
      payload: response,
    };
  };

  const patchCategoryAction = (response) => {
    return {
      type: PATCH_CATEGORY,
      payload: response,
    };
  };

  //thunk
  const getCategory = async () => {
    const response = await axios.get(
      'https://minimi-place.duckdns.org/category'
    );
    console.log(response.data);
  };

  const postCategoryThunk = async () => {
    const body = {
      categoryCode: '000001',
      categoryTitle: '헬스',
      categoryStatus: 'ACTIVE',
    };
    const response = await axios.post(
      'https://minimi-place.duckdns.org/category',
      body
    );
    dispatch(postCategoryAction(response.data));
  };

  const patchCategoryThunk = async () => {
    const body = {
      categoryCode: '000001',
      categoryTitle: '헬스',
      categoryStatus: 'INACTIVE',
    };
    const response = await axios.patch(
      'https://minimi-place.duckdns.org/category/000001',
      body
    );
    dispatch(patchCategoryAction(response.data));
  };

  //button handler
  const getHandler = () => {
    getCategory();
  };

  const postHandler = () => {
    postCategoryThunk();
  };

  const patchHandler = () => {
    patchCategoryThunk();
  };

  return (
    <>
      <AdminGlobal>
        {/* <ReadCategoryForm data={category} /> */}

        <button onClick={getHandler}>get</button>
        <button onClick={postHandler}>post</button>
        <button onClick={patchHandler}>patch</button>
      </AdminGlobal>
    </>
  );
};

export default AdminPage;
