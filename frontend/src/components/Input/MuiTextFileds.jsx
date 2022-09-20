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
