import CircularProgress from '@mui/material/CircularProgress';
import Box from '@mui/material/Box';
import { ThemeProvider } from '@mui/material/styles';
import theme from '../../styles/mui/theme';
import { ModalBackdropStyle } from '../../styles/components/Modalstyle';

export default function CircularIndeterminate() {
  return (
    <ThemeProvider theme={theme}>
      <ModalBackdropStyle>
        <Box sx={{ style }}>
          <CircularProgress color="success" />
        </Box>
      </ModalBackdropStyle>
    </ThemeProvider>
  );
}

const style = {
  position: 'absolute',
  top: '50%',
  left: '50%',
  transform: 'translate(-50%, -50%)',
};
