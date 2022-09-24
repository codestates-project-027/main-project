import styled from 'styled-components';
import { AdminGlobal } from '../styles/globalStyle/PageGlobalStyle';
import { ReadCategoryForm } from '../components/Form/CategoryForms';
import { useState } from 'react';
import { H3 } from '../components/Text/Head';
import { BigBtn } from '../components/Button/Btns';
import { InputCategoryForm } from '../components/Form/CategoryForms';

const AdminPage = () => {
  const [category, setCategory] = useState({});
  const [btnIdx, setBtnIdx] = useState(-1);

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

  const btnContent = ['Read', 'Create', 'Edit'];

  const clickHandler = (idx) => {
    setBtnIdx(idx);
  };

  return (
    <>
      <AdminGlobal>
        <H3 marginBottom="30px" display="flex" justifyContent="center">
          카테고리 목록
        </H3>
        <ReadCategoryForm data={data} />
        <BtnsWrapper>
          {btnContent.map((el, idx) => {
            return (
              <BigBtn
                marginRight="30px"
                key={idx}
                onClick={() => {
                  clickHandler(idx);
                }}
              >
                {el}
              </BigBtn>
            );
          })}
        </BtnsWrapper>
        {btnIdx === 0 ? <InputCategoryForm idx={btnIdx}/> : ''}
        {btnIdx === 1 ? <InputCategoryForm idx={btnIdx}/> : ''}
        {btnIdx === 2 ? <InputCategoryForm idx={btnIdx}/> : ''}
        {/* <button onClick={getHandler}>get</button>
        <button onClick={postHandler}>post</button>
        <button onClick={patchHandler}>patch</button> */}
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
