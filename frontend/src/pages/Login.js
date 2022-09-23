import { Link } from 'react-router-dom';
import CharLogo from '../assets/logo/minimi-char.png';
import { LoginPageGlobal } from '../styles/globalStyle/PageGlobalStyle';
import { IdInput, PwInput } from '../components/InputTextarea/FormInputs';

import { RoundBtn } from '../components/Button/Btns';

const LoginPage = () => {
  return (
    <>
      <LoginPageGlobal>
        <Link to="/">
          <img className="logo" alt="logo" src={CharLogo} />
        </Link>
        <div className="desc--wrapper">miracle place near me</div>
        <div className="login--wrapper">
          <IdInput />
          <PwInput />
          <div className="button--wrapper" style={{ marginTop: '50px' }}>
            <RoundBtn marginBottom={'15px'}>로그인</RoundBtn>
            <RoundBtn
              backGround={'#37474f'}
              color={'white'}
              hoverBg={'#102027'}
            >
              회원가입
            </RoundBtn>
          </div>
        </div>
      </LoginPageGlobal>
    </>
  );
};

export default LoginPage;
