import { Outlet } from 'react-router-dom';
// import TopNavbar from '../../components/Nav/TopNavBar'; //변경된 top bar
import BottomNavbar from '../../components/Bar/BottomNavbar';

const LayoutCurrentMenu = () => {
  return (
    <>
      <header>{/* <TopNavbar /> */}</header>
      <main>
        <Outlet />
      </main>
      <footer>
        <BottomNavbar />
      </footer>
    </>
  );
};

export default LayoutCurrentMenu;
