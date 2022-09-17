import styled from 'styled-components';
import { Link } from 'react-router-dom';
import CharLogo from '../assets/logo/minimi-char.png';
import { LoginPageGlobal } from '../styles/globalStyle/PageGlobalStyle';

const LoginPage = () => {
  return (
    <>
      <LoginPageGlobal>
        <Link to="/">
          <img className="logo" alt="logo" src={CharLogo} />
        </Link>
        <div className="desc--wrapper">miracle place near me</div>
        <div className="login--wrapper">
          <InputTab>
            <input className="input" placeholder="아이디" />
          </InputTab>
          <InputTab>
            <input className="input" placeholder="비밀번호" />
          </InputTab>
          <div className="button--wrapper">
            <Button>로그인</Button>
            <Button2>회원가입</Button2>
            <Button>소셜 로그인</Button>
          </div>
        </div>
      </LoginPageGlobal>
    </>
  );
};

export default LoginPage;

//교체 예정 -> mui
export const InputTab = styled.div`
  display: flex;
  flex-direction: column;
  align-items: flex-start;
  justify-content: center;
  width: 350px;
  height: 50px;
  background: var(--main-navy);
  border-radius: 5px;
  margin-bottom: 15%;
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

const Button = styled.button`
  display: flex;
  align-items: center;
  justify-content: center;
  width: 110px;
  height: fit-content;
  background: var(--logo-yellow);
  border: none;
  border-radius: 25px;
  padding: 15px;
  margin-bottom: 5%;
  cursor: pointer;
`;

const Button2 = styled(Button)`
  background: var(--main-navy);
  color: var(--main-yellow);
`;