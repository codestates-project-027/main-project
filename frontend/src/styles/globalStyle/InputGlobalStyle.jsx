import styled from 'styled-components';

export const NavyInputGlobal = styled.div`
  display: flex;
  flex-direction: column;
  align-items: flex-start;
  justify-content: center;
  width: 350px;
  height: 50px;
  background: var(--main-navy);
  border-radius: 5px;
  margin-bottom: 10px;
  .input {
    display: flex;
    background: transparent;
    text-align: start;
    align-items: center;
    border: none;
    color: var(--logo-yellow);
    margin-left: 20px;
    &:focus {
      outline: transparent;
    }
  }
  .input::placeholder {
    color: var(--main-yellow);
  }
`;

export const WhiteInputGlobal = styled(NavyInputGlobal)`
  background: white;
  width: 430px;
  height: 40px;
  box-shadow: 3px 3px 3px lightgray;
  margin-bottom: 3px;
  .input {
    color: var(--main-navy);
    width: 300px;
  }
  .input::placeholder {
    color: lightgray;
  }
`;
