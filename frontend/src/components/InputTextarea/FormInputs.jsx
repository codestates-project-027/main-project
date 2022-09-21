import { NavyInputGlobal } from '../../styles/globalStyle/InputGlobalStyle';

export const IdInput = () => {
  return (
    <NavyInputGlobal>
      <input className="input" placeholder="아이디" />
    </NavyInputGlobal>
  );
};

export const PwInput = () => {
  return (
    <NavyInputGlobal>
      <input className="input" type="password" placeholder="비밀번호" />
    </NavyInputGlobal>
  );
};
