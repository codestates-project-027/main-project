//기능 구현 후 합칠 예정

import { Outlet } from 'react-router-dom';
import { StyledLink } from '../styles/components/TextStyles';

import {
  TopNavPosition,
  OutletPosition,
  BottomNavPosition,
} from '../styles/position/LayoutPositions';

import { TopNavbar, BottomNavbar } from '../components/Bar/Navbars';

import { StickyBtn } from '../components/Button/Btns';

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
      <LayoutBaseForFacilities />
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

      <StickyBtn>
        <StyledLink to="/registerfac">
          시설 <br />
          등록
        </StyledLink>
      </StickyBtn>

      <BottomNavPosition>
        <BottomNavbar />
      </BottomNavPosition>
    </>
  );
};
