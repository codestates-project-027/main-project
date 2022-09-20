import { createTheme } from '@mui/material/styles';

const theme = createTheme({
  overrides: {
    MuiInput: {
      input: {
        '&::placeholder': {
          color: 'red',
        },
      },
    },
  },
  palette: {
    yellow: {
      light: '#ffff72',
      main: '#FFEB3B', //255,235,59
      dark: '#f5e131',
      logo: '#fae316',
    },
    navy: {
      light: '#62727b',
      main: '#37474f',
      dark: '#102027',
    },
    gray: {
      light: '#f0f0f0',
    },
  },
});

export default theme;
