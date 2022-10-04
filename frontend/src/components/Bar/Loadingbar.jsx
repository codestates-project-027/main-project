import CircularProgress from '@mui/material/CircularProgress';
import Box from '@mui/material/Box';
import { ThemeProvider } from '@mui/material/styles';
import theme from '../../styles/mui/theme';
import { ModalBackdropStyle } from '../../styles/components/Modalstyle';

export default function CircularIndeterminate() {
  return (
    <ThemeProvider theme={theme}>
      <ModalBackdropStyle>
        <Box sx={{ BoxStyle }}>
          <CircularProgress color="yellow" />
        </Box>
      </ModalBackdropStyle>
    </ThemeProvider>
  );
}

// const Loading = () => {

//   return (
//     <div className="loading">
//       <img src="https://upload.wikimedia.org/wikipedia/commons/b/b1/Loading_icon.gif?20151024034921" alt="loading" />
//     </div>
//   );
// }

// export default Loading;

const BoxStyle = {
  position: 'absolute',
  top: '50%',
  left: '50%',
  transform: 'translate(-50%, -50%)',
};
