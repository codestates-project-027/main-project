import {
  NavyInputGlobal,
  WhiteInputGlobal,
} from '../../styles/globalStyle/InputGlobalStyle';

export const Input = ({ label, type, placeholder, IDPW, maxlength }) => {
  return IDPW ? (
    <NavyInputGlobal>
      <input
        className="input"
        type={type}
        placeholder={placeholder}
        maxlength={maxlength}
      />
    </NavyInputGlobal>
  ) : (
    <WhiteInputGlobal>
      <input
        className="input"
        type={type}
        placeholder={placeholder}
        id={label}
        maxlength={maxlength}
      />
    </WhiteInputGlobal>
  );
};
