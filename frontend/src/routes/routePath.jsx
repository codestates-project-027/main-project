const PATH = {
  TEST: '/test',

  MAIN: '/',

  SIGNUP: '/signup',
  LOGIN: '/login',
  MYPAGE: '/mypage',

  FACILITY: '/facility/:id', 
  FACILITIES: '/facility', //facility

  REGISTERFACILITY: '/facility/register',
  EDITFACILITY: '/editfac', //->facility/edit/:id
  EDITMY: '/facility/my',
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
