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
  required,
}) => {
  return IDPW ? (
    <NavyInputGlobal>
      <input
        required={required}
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
        required={required}
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
