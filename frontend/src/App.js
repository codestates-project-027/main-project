import './App.css';
import { useEffect, useState } from 'react';
import { Routes, Route } from 'react-router-dom';

//API Call
import api from './api/api-toEdit';

//Routes
import PATH from './routes/routePath';

//GlobalStyle
import { AppPageGlobal } from './styles/globalStyle/PageGlobalStyle';

//Layouts
import {
  LayoutBase,
  LayoutMain,
  LayoutCurrentMenu,
  LayoutCurrentMenuSearch,
} from './layouts/Layouts';

//Pages
import LoginPage from './pages/Login';
import SignUpPage from './pages/SignUp';
import MainPage from './pages/Main';
import FacilityPage from './pages/Facility';
import FacilitiesPage from './pages/Facilities';
import MyPage from './pages/MyPage';
import AlarmsPage from './pages/Alarms';
import MapPage from './pages/Map';
import TestPage from './pages/Test';
import EditMyFacilityPage from './pages/EditMyFacility';

import CommunityPage from './pages/Community';
import WritingPage from './pages/WritingPost';
import PostingPage from './pages/Posting';

function App() {
  const [test, setTest] = useState('');

  const getData = () => {
    api.Test.get().then((data) => {
      setTest(data);
    });
  };

  useEffect(() => {
    getData();
  }, []);

  console.log(test); // server OK

  return (
    <>
      <div className="App">
        <AppPageGlobal>
          <Routes>
            <Route element={<LayoutBase />}>
              <Route path={PATH.TEST} element={<TestPage />} />
              <Route path={PATH.SIGNUP} element={<SignUpPage />} />
              <Route path={PATH.LOGIN} element={<LoginPage />} />
            </Route>

            <Route element={<LayoutMain />}>
              <Route path={PATH.MAIN} element={<MainPage />} />
            </Route>

            <Route element={<LayoutCurrentMenu />}>
              <Route path={PATH.MYPAGE} element={<MyPage />} />
              <Route path={PATH.FACILITY} element={<FacilityPage />} />
              <Route path={PATH.MAP} element={<MapPage />} />
              <Route path={PATH.ALARMS} element={<AlarmsPage />} />
              <Route path={PATH.EDITMY} element={<EditMyFacilityPage />} />
              <Route path={PATH.COMMUNITY} element={<CommunityPage />} />
              <Route path={PATH.COMMUNITIYWRITING} element={<WritingPage />} />
              <Route path={PATH.COMMUNITIYPOSTING} element={<PostingPage />} />

              {/* 시설 등록 페이지 */}
            </Route>

            <Route element={<LayoutCurrentMenuSearch />}>
              <Route path={PATH.FACILITIES} element={<FacilitiesPage />} />
            </Route>
          </Routes>
        </AppPageGlobal>
      </div>
    </>
  );
}

export default App;
