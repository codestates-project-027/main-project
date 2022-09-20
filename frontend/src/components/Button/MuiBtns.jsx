import Button from '@mui/material/Button';

export const YellowBtn = ({ text }) => {
  return (
    <Button
      variant="contained"
      sx={{ borderRadius: '16px' }}
      color="yellow"
      style={{ width: '113px', marginBottom: '15px' }}
    >
      {text}
    </Button>
  );
};

export const NavyBtn = ({ text }) => {
  return (
    <Button
      variant="contained"
      sx={{ borderRadius: '16px' }}
      color="navy"
      style={{ color: 'white', width: '113px', marginBottom: '15px' }}
    >
      {text}
    </Button>
  );
};

