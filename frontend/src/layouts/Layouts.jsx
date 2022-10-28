//기능 구현 후 합칠 예정
import { Outlet, useParams } from 'react-router-dom';
import { StyledLink } from '../styles/components/TextStyles';
import GlobalStyle from '../styles/globalStyle/GlobalStyle';
import { CurrentPath } from '../routes/routePath';
import PATH from '../routes/routePath';
import { useState } from 'react';

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
import { useEffect } from 'react';

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

export const LayoutBase = ({ fin, setFin }) => {
  return (
    <>
      <LayoutBaseForFacilities />
      <BottomNavPosition>
        <BottomNavbar fin={fin} setFin={setFin} />
      </BottomNavPosition>
    </>
  );
};

export const LayoutMain = ({ city }) => {
  useEffect(() => {}, [city]);
  return (
    <>
      <TopNavPosition>
        <TopNavbar type={city === '' ? '주소를 설정하세요' : city} />
      </TopNavPosition>
      <LayoutBase />
    </>
  );
};

export const LayoutCurrentMenu = ({ type, data }) => {
  const [cmenu, setCmenu] = useState('Minimi');
  const { id } = useParams();
  const cpath = window.location.pathname;
  const CurrentPath = () => {
    if (cpath === PATH.MYPAGE) {
      return '나의 정보';
    } else if (cpath === `/facility/${id}`) {
      return data.facilityName;
    } else if (cpath === PATH.REGISTERFACILITY) {
      return '시설 등록';
    } else if (cpath === `/facility/edit/${id}`) {
      return '시설 변경';
    } else if (cpath === PATH.MAP) {
      return '지도로 보기';
    } else if (cpath === PATH.ALARMS) {
      return '알람';
    } else if (cpath === PATH.ADMIN) {
      return '관리자 페이지';
    }
  };

  useEffect(() => {
    setCmenu(CurrentPath());
  }, [cpath,data]);
  return (
    <>
      <TopNavPosition>
        <TopNavbar type={cmenu} />
      </TopNavPosition>
      <LayoutBase />
    </>
  );
};

export const LayoutCurrentMenuSearch = ({ fin, setFin }) => {
  return (
    <>
      <TopNavPosition>
        <TopNavbar type={'시설 목록'} />
      </TopNavPosition>
      <LayoutBaseForFacilities />

      <StickyBtn>
        <StyledLink to="/facility/register">
          시설 <br />
          등록
        </StyledLink>
      </StickyBtn>

      <BottomNavPosition>
        <BottomNavbar fin={fin} setFin={setFin} />
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
