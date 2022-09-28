import TextField from '@mui/material/TextField';
import { TextFieldStyle } from '../../styles/mui/TextFieldStyle';

export const BasicTextField = ({ text }) => {
  return (
    <TextField
      required
      id="filled-multiline-flexible"
      label={text}
      defaultValue=""
      color="yellow"
      variant="filled"
      sx={{
        borderRadius: '5px',
        input: { color: 'white' },
        marginBottom: '10px',
      }}
      style={TextFieldStyle}
    >
      {text}
    </TextField>
  );
};

export const TitleTextField = ({ text, onChange, value, inputProps }) => {
  return (
    <TextField
      id="standard-textarea"
      placeholder="Placeholder"
      multiline
      variant="standard"
      {...inputProps}
      onChange={onChange}
      value={value}
      sx={{
        width: '40ch',
      }}
    >
      {text}
    </TextField>
  );
};

export const ContentsTextField = ({ text, onChange, value, inputProps }) => {
  return (
    <TextField
      id="filled-multiline-static"
      multiline
      rows={10}
      defaultValue="Default Value"
      variant="filled"
      {...inputProps}
      onChange={onChange}
      value={value}
      sx={{
        width: '60ch',
      }}
    >
      {text}
    </TextField>
  );
};
