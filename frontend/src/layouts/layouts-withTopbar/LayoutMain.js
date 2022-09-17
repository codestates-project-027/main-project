import { Outlet } from 'react-router-dom';
import TopNavbar from '../../components/Bar/TopNavbar';
import BottomNavbar from '../../components/Bar/BottomNavbar';

const LayoutMain = () => {
  return (
    <>
      <header>
        <TopNavbar />
      </header>
      <main>
        <Outlet />
      </main>
      <footer>
        <BottomNavbar />
      </footer>
    </>
  );
};

export default LayoutMain;
