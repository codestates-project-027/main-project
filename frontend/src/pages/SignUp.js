import CharLogo from '../assets/logo/minimi-char.png';
import { SignUpPageGlobal } from '../styles/globalStyle/PageGlobalStyle';

const SignUpPage = () => {
  return (
    <SignUpPageGlobal>
      <div>
        <img className="logo" alt="logo" src={CharLogo}></img>
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
    </SignUpPageGlobal>
  );
};

export default SignUpPage;
