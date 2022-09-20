import { Outlet } from 'react-router-dom';

import {
  TopNavPosition,
  OutletPosition,
  BottomNavPosition,
} from '../styles/position/LayoutPositions';

import {
  TopNavbarMain,
  TopNavbarMenu,
  TopNavbarMenuSearch,
} from '../components/Bar/TopNavbars';

import BottomNavbar from '../components/Bar/BottomNavbar';

export const LayoutMain = () => {
  return (
    <>
      <TopNavPosition>
        <TopNavbarMain />
      </TopNavPosition>
      <OutletPosition>
        <Outlet />
      </OutletPosition>
      <BottomNavPosition>
        <BottomNavbar />
      </BottomNavPosition>
    </>
  );
};

export const LayoutCurrentMenu = () => {
  return (
    <>
      <TopNavPosition>
        <TopNavbarMenu />
      </TopNavPosition>
      <OutletPosition>
        <Outlet />
      </OutletPosition>
      <BottomNavPosition>
        <BottomNavbar />
      </BottomNavPosition>
    </>
  );
};

export const LayoutCurrentMenuSearch = () => {
  return (
    <>
      <TopNavPosition>
        <TopNavbarMenuSearch />
      </TopNavPosition>
      <OutletPosition>
        <Outlet />
      </OutletPosition>
      <BottomNavPosition>
        <BottomNavbar />
      </BottomNavPosition>
    </>
  );
};
