import CircularProgress from '@mui/material/CircularProgress';
import Box from '@mui/material/Box';
import { ThemeProvider } from '@mui/material/styles';
import theme from '../../styles/mui/theme';

export default function CircularIndeterminate() {
  return (
    <ThemeProvider theme={theme}>
      <Box sx={{ display: 'flex' }}>
        <CircularProgress color="primary" />
      </Box>
    </ThemeProvider>
  );
}

