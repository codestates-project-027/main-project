import { useState } from 'react';

const PATH = {
  TEST: '/test',

  MAIN: '/',

  SIGNUP: '/signup',
  LOGIN: '/login',
  MYPAGE: '/mypage',

  CATEGORY: '/category/:id',

  FACILITY: '/facility/:id',
  FACILITIES: '/facility',

  REGISTERFACILITY: '/facility/register',
  EDITFACILITY: '/facility/edit/:id',

  MAP: '/map',
  ALARMS: '/alarms',

  COMMUNITY: '/community',
  COMMUNITIYWRITING: '/community-writing',
  COMMUNITIYPOSTING: '/community-posting',
  EDITCOMMUNITIY: 'edit-community',

  ADMIN: '/admin',
};

export default PATH;

// export const CurrentPath = () => {
//   const cpath = window.location.pathname;
//   const [cmenu, setCmenu] = useState('미니미');
//   if (cpath === PATH.MYPAGE) {
//     setCmenu('나의 정보');
//   } else if (cpath === PATH.FACILITY) {
//     setCmenu('fac id');
//   } else if (cpath === PATH.FACILITIES) {
//     setCmenu('fac 이름');
//   } else if (cpath === PATH.REGISTERFACILITY) {
//     setCmenu('시설 등록하기');
//   } else if (cpath === PATH.EDITFACILITY) {
//     setCmenu('시설 변경하기');
//   } else if (cpath === PATH.MAP) {
//     setCmenu('지도로 보기');
//   } else if (cpath === PATH.ALARMS) {
//     setCmenu('알람');
//   } else if (cpath === PATH.ADMIN) {
//     setCmenu('관리자 페이지');
//   }
//   return <div>{cmenu}</div>;
// };
