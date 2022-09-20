import styled from 'styled-components';
import { PADDING } from '../../constants/style';

export const PageGlobalBase = styled.div`
  display: flex;
  flex-direction: column;
  padding: 30px;
`;

export const AppPageGlobal = styled(PageGlobalBase)`
  align-items: center;
  height: 100vh;
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
  .logo {
    width: 80px;
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
  }

  button {
    border: 1px solid var(--main-yellow);
    border-radius: 0.6rem;
    background-color: var(--main-yellow);
    margin: 0.7rem;
    width: 7rem;
    height: 2.5rem;
  }
`;

export const FacilitiesPageGlobal = styled(PageGlobalBase)`
  justify-content: center;
  align-items: center;
  width: 100vw;

  .tags--wrapper {
    display: flex;
    justify-content: flex-start;
    align-items: center;
    width: 400px;
    margin: 15px;
    margin-left: 85px;
    @media screen and (max-width: 790px) {
      margin-left: 50px;
      width: 400px;
    }
    .title {
      margin-left: 10px;
    }
  }
`;

export const FacilityPageGlobal = styled(PageGlobalBase)`
  background-color: bisque;
  .img--wrapper {
    display: flex;
    justify-content: center;
    align-items: center;
    width: 550px;
    height: 300px;
    background-color: lightgreen;
    margin-bottom: 10px;
    padding: ${PADDING.BASIC};
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
`;

export const MyPageGlobal = styled(PageGlobalBase)`
  background-color: aliceblue;
  padding: ${PADDING.BASIC};
  .card--wrapper {
    display: flex;
    justify-content: center;
    align-items: center;
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
