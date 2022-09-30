//기능 구현 후 합칠 예정
import { Outlet } from 'react-router-dom';
import { StyledLink } from '../styles/components/TextStyles';
import GlobalStyle from '../styles/globalStyle/GlobalStyle';

import {
  TopNavPosition,
  OutletPosition,
  BottomNavPosition,
} from '../styles/position/LayoutPositions';

import {
  TopNavbar,
  BottomNavbar,
  CommunityTopNavbar,
} from '../components/Bar/Navbars';

import { StickyBtn } from '../components/Button/Btns';

export const LayoutBaseForFacilities = () => {
  return (
    <>
      <GlobalStyle />
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
  return (
    <>
      <TopNavPosition>
        <TopNavbar type={'현재 메뉴 + search icon'} />
      </TopNavPosition>
      <LayoutBaseForFacilities />

      <StickyBtn>
        <StyledLink to="/facility/register">
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

export const LayoutCommunity = () => {
  return (
    <>
      <TopNavPosition>
        <CommunityTopNavbar type={'커뮤니티'} />
      </TopNavPosition>
      <LayoutBase />
    </>
  );
};
