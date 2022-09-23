import {
  NavyInputGlobal,
  WhiteInputGlobal,
} from '../../styles/globalStyle/InputGlobalStyle';

export const Input = ({ label, type, placeholder, IDPW }) => {
  return IDPW ? (
    <NavyInputGlobal>
      <input className="input" type={type} placeholder={placeholder} />
    </NavyInputGlobal>
  ) : (
    <WhiteInputGlobal>
      <input className="input" placeholder={placeholder} id={label} />
    </WhiteInputGlobal>
  );
};
