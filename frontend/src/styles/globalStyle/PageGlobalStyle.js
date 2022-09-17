import styled from 'styled-components';

export const MainPageGlobal = styled.div`
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
  width: 100vw;
`;

export const LoginPageGlobal = styled.div`
  display: flex;
  flex-direction: column;
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

export const SignUpPageGlobal = styled.div`
  display: flex;
  flex-direction: column;
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

export const FacilitiesPageGlobal = styled.div`
  display: flex;
  justify-content: center;
  align-items: center;
  flex-direction: column;
  width: 100vw;

  .tags--wrapper {
    display: flex;
    justify-content: flex-start;
    align-items: center;
    width: 40%;
    margin: 15px;
    @media screen and (max-width: 790px) {
      width: 55%;
    }
    .title {
      margin-left: 10px;
    }
  }
`;
