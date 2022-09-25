import styled from 'styled-components';
import { AdminGlobal } from '../styles/globalStyle/PageGlobalStyle';
import { ReadCategoryForm } from '../components/Form/CategoryForms';
import { useState, useEffect } from 'react';
import { H3 } from '../components/Text/Head';
import { BigBtn } from '../components/Button/Btns';
import { InputCategoryForm } from '../components/Form/CategoryForms';
import { useSelector, useDispatch } from 'react-redux';
import { getCategory } from '../redux/slices/categorySlice';
import axios from 'axios';

const AdminPage = () => {
  const dispatch = useDispatch();
  const categoryState = useSelector((state) => state.category); //state:initialState, category:slice name, category: category reducer
  const [category, setCategory] = useState({});
  const [btnIdx, setBtnIdx] = useState(0);
  const [type, setType] = useState('');
  const list = categoryState.list;

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

  const getCategoryTest = async () => {
    await axios.get('https://minimi-place.duckdns.org/category').then((res) => {
      dispatch(getCategory({ list: res.data }));
      console.log('categoryState:', categoryState);
    });
  };

  // useEffect(() => {
  //   getCategoryTest()

  //   // dispatch(getCategory({list:['3']}));
  //   console.log(category)
  // }, [dispatch]);

  const btnContent = ['Read', 'Create', 'Edit'];

  const clickBtn = (idx) => {
    setBtnIdx(idx);
    if (idx === 0) {
      getCategoryTest();
      console.log('categoryState:', categoryState);
    } else if (idx === 1) {
      setType('생성');
    } else setType('수정');
  };

  return (
    <>
      <AdminGlobal>
        <H3 marginBottom="30px" display="flex" justifyContent="center">
          카테고리 목록 
        </H3>
        <ReadCategoryForm data={categoryState.list} />
        <BtnsWrapper>
          {btnContent.map((el, idx) => {
            return (
              <BigBtn
                marginRight="30px"
                key={idx}
                onClick={() => {
                  clickBtn(idx);
                }}
              >
                {el}
              </BigBtn>
            );
          })}
        </BtnsWrapper>
        {btnIdx !== 0 ? <InputCategoryForm type={type} idx={btnIdx} /> : ''}
      </AdminGlobal>
    </>
  );
};

export default AdminPage;

const BtnsWrapper = styled.div`
  display: flex;
  justify-content: center;
  align-items: center;
  width: 500px;
  height: 100px;
  margin-top: 50px;
`;
