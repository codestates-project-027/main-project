import { Link } from 'react-router-dom';
import CharLogo from '../assets/logo/minimi-char.png';
import { LoginPageGlobal } from '../styles/globalStyle/PageGlobalStyle';
import { Input } from '../components/InputTextarea/FormInputs';
import styled from 'styled-components';

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
          <Input IDPW="IDPW" placeholder="아이디" />
          <Input IDPW="IDPW" placeholder="비밀번호" type="password" />
          <Div className="button--wrapper">
            <RoundBtn marginBottom={'15px'}>로그인</RoundBtn>
            <Link to="/signup">
              <RoundBtn
                backGround={'#37474f'}
                color={'white'}
                hoverBg={'#102027'}
              >
                회원가입
              </RoundBtn>
            </Link>
          </Div>
        </div>
      </LoginPageGlobal>
    </>
  );
};

export default LoginPage;

const Div = styled.div`
  margin-top: 50px;
`;
