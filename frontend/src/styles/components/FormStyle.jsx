import styled from 'styled-components';
import { BigBtn } from '../../components/Button/Btns';

export const FacilityFormStyle = styled.div`
  display: flex;
  align-items: flex-start;
  justify-content: center;
  background-color: #f3f3f3;
  flex-direction: column;
  width: 580px;
  height: fit-content;
  padding: 37px;
  border-radius: 10px;
  box-shadow: 2px 2px 2px lightgray;
  .input--wrapper {
    display: flex;
    align-items: center;
    justify-content: center;
    margin-top: 20px;
  }
  .tags--wrapper {
    display: flex;
    align-items: center;
    margin-top: 30px;
  }
  .btn--wrapper {
    display: flex;
    width: 100%;
    align-items: center;
    justify-content: center;
    margin-top: 20px;
  }
`;

export const FacilityFormWrapper = styled.div`
  input {
    width: ${(props) => props.width || '200px'};
    height: 40px;
    border: none;
    box-shadow: 3px 3px 3px lightgray;
    color: var(--main-navy);
    border-radius: 5px;
    ::placeholder {
      color: lightgray;
    }
  }
`;
export const CategoryFormWrapper = styled(FacilityFormWrapper)`
  display: flex;
  background: aliceblue;
  justify-content: center;
  flex-direction: column;
  margin-top: 30px;
  width: 500px;
  height: 250px;
  .input--wrapper {
    display: flex;
    margin-bottom: 10px;
  }

  div {
    margin-left: 20px;
    align-items: center;
  }
  select {
    margin-left: 20px;
  }
  ${BigBtn} {
    margin-left: 50px;
  }
`;
