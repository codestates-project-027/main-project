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
  // EDITFACILITY: '/editfac', //->facility/edit/:id
  EDITFACILITY: '/facility/edit/:id', //->facility/edit/:id
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
