import styled from 'styled-components';
import icon from '../assets/icon/미니미캐릭터.png';

const SignupPage = () => {
  return (
    <SignupWrapper>
      <div>
        <img className="logo" alt="logo" src={icon}></img>
      </div>
      <div className="signup-container">
        <div className="signup-info">
          <input placeholder="아이디" />
          <input placeholder="비밀번호" type="password" />
          <input placeholder="비밀번호 확인" type="password" />
        </div>
        <div className="signup-button">
          <button>회원가입</button>
        </div>
      </div>
    </SignupWrapper>
  );
};

export default SignupPage;

const SignupWrapper = styled.div`
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
