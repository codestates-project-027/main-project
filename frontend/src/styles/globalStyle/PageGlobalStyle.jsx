import styled from 'styled-components';
import { PADDING } from '../../constants/style';

export const PageGlobalBase = styled.div`
  display: flex;
  justify-content: center;
  margin-top: 40px;
  flex-direction: column;
  padding: 30px;
  margin-bottom: 40px;
`;

export const AppPageGlobal = styled(PageGlobalBase)`
  align-items: center;
  height: 100%;
  padding: 0;
`;

export const MainPageGlobal = styled(PageGlobalBase)`
  justify-content: center;
  align-items: center;
  width: 100vw;
`;

export const LoginPageGlobal = styled(PageGlobalBase)`
  .logo {
    width: 80px;
  }
  .desc--wrapper {
    margin-top: 13%;
    font-family: 'Bazzi';
    font-size: 1.3rem;
  }
  .login--wrapper {
    margin-top: 10%;
  }
  .button--wrapper {
    display: flex;
    flex-direction: column;
    align-items: center;
    justify-content: center;
  }
`;

export const SignUpPageGlobal = styled(PageGlobalBase)`
  display: flex;
  flex-direction: column;
  .logo {
    width: 10vh;
  }
  .signup-container {
    padding: 1rem;
  }
  .signup-info {
    display: flex;
    flex-direction: column;
    align-items: center;
    width: 15rem;
    height: 15rem;
  }
  input {
    margin: 1rem;
    padding: 0.5rem;
    width: 20rem;
    height: 5vh;
    text-align: start;
  }
  .email-confirm-message {
    color: red;
    font-size: 10px;
    position: relative;
    bottom: 1vh;
    right: 5.5rem;
  }
  .password-message {
    color: red;
    font-size: 10px;
    position: relative;
    bottom: 1vh;
    right: 6.5rem;
  }
  .password-message-length {
    color: red;
    font-size: 10px;
    position: relative;
    bottom: 1vh;
    right: 5rem;
  }
  .id-message {
    color: red;
    font-size: 10px;
    position: relative;
    bottom: 1vh;
    right: 3.7rem;
  }
  .confirm-message {
    color: red;
    font-size: 10px;
    position: relative;
    bottom: 1vh;
    right: 6rem;
  }
  button {
    border: 1px solid var(--main-yellow);
    border-radius: 0.6rem;
    background-color: var(--main-yellow);
    position: relative;
    top: 5rem;
    width: 7rem;
    height: 2.5rem;
  }
`;

export const FacilitiesPageGlobal = styled(PageGlobalBase)`
  display: flex;
  justify-content: center;
  align-items: center;
  width: 100%;
  .map {
    margin-left: 70px;
  }
  .tags--wrapper {
    display: flex;
    justify-content: center;
    align-items: center;
    width: 400px;
    margin: 15px;
    margin-left: 100px;
    @media screen and (max-width: 790px) {
      margin-left: 50px;
      width: 450px;
    }
    .title {
      margin-left: 10px;
    }

    @media screen and (max-width: 476px) {
      display: flex;
      justify-content: center;
      width: 400px;
    }
  }
`;

export const FacilityPageGlobal = styled(PageGlobalBase)`
  display: flex;
  background-color: #f3f3f3; //#fffdb9
  border-radius: 10px;
  box-shadow: 2px 2px 2px lightgray;
  .setIcon--wrapper {
    display: flex;
    justify-content: right;
    margin-bottom: 20px;
    color: #7b7b7b;
  }

  .Fname--distance--wrapper {
    display: flex;
    align-items: center;
    justify-content: space-between;
    padding: ${PADDING.BASIC};
  }
  .minimi--score--wrapper {
    display: flex;
    align-items: center;
    padding: ${PADDING.BASIC};
  }
  .tags--wrapper {
    display: flex;
  }
  .btns--wrapper {
    display: flex;
    justify-content: center;
    align-items: center;
    margin-top: 20px;
    .left--btn {
      margin-right: 20px;
    }
  }
  .reviews--wrapper {
    display: flex;
    flex-direction: column;
  }
  @media screen and (max-width: 790px) {
    display: flex;
    margin-left: 50px;
    width: 450px;
  }
  @media screen and (max-width: 476px) {
    display: flex;
    width: 400px;
  }
`;

export const MyPageGlobal = styled(PageGlobalBase)`
  background-color: aliceblue;
  padding: ${PADDING.BASIC};
  .card--wrapper {
    display: flex;
    justify-content: center;
    align-items: center;
  }
  .facility--wrapper {
    display: flex;
    justify-content: space-between;
  }
`;

export const AlarmsPageGlobal = styled(PageGlobalBase)`
  .card--wrapper {
    display: flex;
    flex-direction: column;
    justify-content: center;
    align-items: center;
    margin-top: 30px;
  }
`;

export const EditMyFacilityGlobal = styled(PageGlobalBase)`
  display: flex;
  width: 100%;
  .facility--wrapper {
    width: 400px;
  }
  @media screen and (max-width: 790px) {
    margin-left: 50px;
    width: 90%;
  }
`;

export const FacilityGlobal = styled(PageGlobalBase)`
  @media screen and (max-width: 790px) {
    display: flex;
    margin-left: 50px;
    width: 90%;
  }
`;

export const AdminGlobal = styled(PageGlobalBase)`
  @media screen and (max-width: 790px) {
    display: flex;
    margin-left: 50px;
    width: 90%;
  }
`;

// export const RegisterFacGlobal = styled(PageGlobalBase)``;

// export const EditFacGlobal = styled(RegisterFacGlobal)``;
