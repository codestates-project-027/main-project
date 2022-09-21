import { Link } from 'react-router-dom';
import CharLogo from '../assets/logo/minimi-char.png';
import { LoginPageGlobal } from '../styles/globalStyle/PageGlobalStyle';
import { IdInput, PwInput } from '../components/InputTextarea/FormInputs';
//mui
import { ThemeProvider } from '@mui/material/styles';
import theme from '../styles/mui/theme';
import { YellowBtn, NavyBtn } from '../components/Button/MuiBtns';
import { BasicTextField } from '../components/InputTextarea/MuiTextFileds';

const LoginPage = () => {
  return (
    <>
      <LoginPageGlobal>
        <ThemeProvider theme={theme}>
          <Link to="/">
            <img className="logo" alt="logo" src={CharLogo} />
          </Link>
          <div className="desc--wrapper">miracle place near me</div>
          <div className="login--wrapper">
            <IdInput />
            <PwInput />
            <div className="button--wrapper" style={{ marginTop: '50px' }}>
              <YellowBtn text={'로그인'} />
              <NavyBtn text={'회원가입'} />
              <YellowBtn text={'소셜 로그인'} />
            </div>
          </div>
        </ThemeProvider>
      </LoginPageGlobal>
    </>
  );
};

export default LoginPage;
