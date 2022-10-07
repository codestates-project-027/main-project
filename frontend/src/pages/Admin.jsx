import styled from 'styled-components';
import { AdminGlobal } from '../styles/globalStyle/PageGlobalStyle';
import { ReadCategoryForm } from '../components/Form/CategoryForms';
import { useState, useEffect, useCallback } from 'react';
import { H3 } from '../components/Text/Head';
import { BigBtn } from '../components/Button/Btns';
import { InputCategoryForm } from '../components/Form/CategoryForms';
import { useSelector, useDispatch } from 'react-redux';
import { getCategory } from '../redux/slices/categorySlice';
import axiosInstance from '../api/Interceptor';

const AdminPage = ({fin,setFin}) => {
  const dispatch = useDispatch();
  const categoryState = useSelector((state) => state.category); //state:initialState, category:slice name, category: category reducer
  const [btnIdx, setBtnIdx] = useState(0);
  const [type, setType] = useState('');
  const [toggle, setToggle]=useState(false)

  const getCategoryAXIOS = useCallback(async () => {
    await axiosInstance.get('/category?active=false').then((res) => {
      dispatch(getCategory({ list: res.data }));
    });
  }, [dispatch]);

  const clickBtn = (idx) => {
    setBtnIdx(idx);
    if (idx === 0) {
      setToggle(!toggle)
      setType('생성');
    } else if (idx === 1) {
      setToggle(!toggle)
      setType('수정');
    }
  };

  useEffect(() => {
    getCategoryAXIOS();
  }, [fin]);

  const btnContent = ['Create', 'Edit'];

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
        {toggle === true ? (
          <InputCategoryForm
            fin={fin}
            setFin={setFin}
            type={type}
            idx={btnIdx}
          />
        ) : (
          ''
        )}
        {/* {console.log(toggle, fin)} */}
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
