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

export const LayoutBase = () => {
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

export const LayoutMain = () => {
  return (
    <>
      <TopNavPosition>
        <TopNavbarMain />
      </TopNavPosition>
      <LayoutBase />
    </>
  );
};

export const LayoutCurrentMenu = () => {
  return (
    <>
      <TopNavPosition>
        <TopNavbarMenu />
      </TopNavPosition>
      <LayoutBase />
    </>
  );
};

export const LayoutCurrentMenuSearch = () => {
  return (
    <>
      <TopNavPosition>
        <TopNavbarMenuSearch />
      </TopNavPosition>
      <LayoutBase />
    </>
  );
};
