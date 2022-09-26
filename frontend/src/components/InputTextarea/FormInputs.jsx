import {
  NavyInputGlobal,
  WhiteInputGlobal,
} from '../../styles/globalStyle/InputGlobalStyle';

export const Input = ({
  name,
  label,
  type,
  placeholder,
  IDPW,
  maxLength,
  value,
  onChange,
  width,
}) => {
  return IDPW ? (
    <NavyInputGlobal>
      <input
        className="input"
        type={type}
        placeholder={placeholder}
        maxLength={maxLength}
        value={value}
        onChange={onChange}
      />
    </NavyInputGlobal>
  ) : (
    <WhiteInputGlobal>
      <input
        name={name}
        className="input"
        type={type}
        placeholder={placeholder}
        id={label}
        maxLength={maxLength}
        value={value}
        onChange={onChange}
      />
    </WhiteInputGlobal>
  );
};
