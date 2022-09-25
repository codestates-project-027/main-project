//constants
const GET_CATEGORY = 'GET_CATEGORY';
const POST_CATEGORY = 'POST_CATEGORY';
const PATCH_CATEGORY = 'PATCH_CATEGORY';

//action creators
const getCategoryAction = (res) => {
  return {
    type: GET_CATEGORY,
    payload: res,
  };
};

const postCategoryAction = (res) => {
  return {
    type: POST_CATEGORY,
    payload: res,
  };
};

const patchCategoryAction = (res) => {
  return {
    type: PATCH_CATEGORY,
    payload: res,
  };
};
