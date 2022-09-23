import { Outlet } from 'react-router-dom';

import {
  TopNavPosition,
  OutletPosition,
  BottomNavPosition,
} from '../styles/position/LayoutPositions';

import { TopNavbar, BottomNavbar } from '../components/Bar/Navbars';

import { StickyBtnStyle } from '../styles/components/BtnStyles';

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
        <TopNavbar type={'우리 동네 주소'} />
      </TopNavPosition>
      <LayoutBase />
    </>
  );
};

export const LayoutCurrentMenu = () => {
  return (
    <>
      <TopNavPosition>
        <TopNavbar type={'현재 메뉴'} />
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
        <TopNavbar type={'현재 메뉴 + search icon'} />
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
