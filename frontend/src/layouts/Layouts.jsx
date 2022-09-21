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

import { StickyBtnStyle } from '../styles/components/BtnStyles';

import BottomNavbar from '../components/Bar/BottomNavbar';

export const LayoutBaseForFacilities = () => {
  return (
    <>
      <OutletPosition>
        <Outlet />
      </OutletPosition>
    </>
  );
};

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
  //LayoutForFacilities
  return (
    <>
      <TopNavPosition>
        <TopNavbarMenuSearch />
      </TopNavPosition>
      <LayoutBaseForFacilities />

      <StickyBtnStyle>
        시설
        <br />
        등록
      </StickyBtnStyle>

      <BottomNavPosition>
        <BottomNavbar />
      </BottomNavPosition>
    </>
  );
};
