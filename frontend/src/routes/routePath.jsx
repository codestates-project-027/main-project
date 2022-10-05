const PATH = {
  TEST: '/test',

  MAIN: '/',

  SIGNUP: '/signup',
  LOGIN: '/login',
  MYPAGE: '/mypage',

  CATEGORY: '/category/:id',

  FACILITY: '/facility/:id', //무한 요청
  FACILITIES: '/facility', 

  REGISTERFACILITY: '/facility/register',
  EDITFACILITY: '/facility/edit/:id', //->facility/edit/:id
  // POSTREVIEW, EDITREVIEW-> Modal창

  MAP: '/map',
  ALARMS: '/alarms',

  COMMUNITY: '/community',
  COMMUNITIYWRITING: '/community-writing',
  COMMUNITIYPOSTING: '/community-posting',
  EDITCOMMUNITIY: 'edit-community',

  ADMIN: '/admin',
};

export default PATH;
