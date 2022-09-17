import { Outlet } from 'react-router-dom';
import BottomNavbar from '../components/Bar/BottomNavbar';
import {
  OutletPosition,
  BottomNavPosition,
} from '../styles/position/LayoutPosition';

const LayoutNoTopbar = () => {
  return (
    <>
      <OutletPosition>
        <Outlet />
      </OutletPosition>
      <BottomNavPosition>
        <BottomNavbar />
      </BottomNavPosition>
    </>
  );
};

export default LayoutNoTopbar;
