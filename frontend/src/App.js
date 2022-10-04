import './App.css';
import { useState, Suspense } from 'react';
import { Routes, Route } from 'react-router-dom';

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
  LayoutCommunity,
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

import { RegisterFacilityPage } from './pages/HandleFacility';
import { EditFacilityPage } from './pages/HandleFacility';

import AdminPage from './pages/Admin';

import CommunityPage from './pages/Community';
import WritingPage from './pages/AddPost';
import PostingPage from './pages/Posting';
import EditPostPage from './pages/EditPost';

//Loading
import CircularIndeterminate from './components/Bar/Loadingbar';

function App() {
  const [pending, setPending] = useState(true);

  return (
    <>
      <div className="App">
        <Suspense fallback={<CircularIndeterminate />}>
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
                <Route
                  path={PATH.MYPAGE}
                  element={<MyPage type="마이 페이지" />}
                />
                <Route
                  path={PATH.FACILITY}
                  element={<FacilityPage type="운동 시설" />}
                />
                <Route
                  path={PATH.REGISTERFACILITY}
                  element={<RegisterFacilityPage type="시설 등록" />}
                />
                <Route
                  path={PATH.EDITFACILITY}
                  element={<EditFacilityPage type="시설 변경" />}
                />

                <Route
                  path={PATH.MAP}
                  element={<MapPage type="지도로 보기" />}
                />
                <Route
                  path={PATH.ALARMS}
                  element={<AlarmsPage type="알림" />}
                />
                {/* <Route
                  path={PATH.EDITMY}
                  element={<EditMyFacilityPage type="내 정보 수정" />}
                /> */}

                <Route path={PATH.COMMUNITY} element={<CommunityPage />} />
                <Route
                  path={PATH.COMMUNITIYWRITING}
                  element={<WritingPage />}
                />
                <Route
                  path={PATH.COMMUNITIYPOSTING}
                  element={<PostingPage />}
                />

                <Route
                  path={PATH.ADMIN}
                  element={<AdminPage type="관리자 페이지" />}
                />
              </Route>

              {/* community */}
              <Route element={<LayoutCommunity />}>
                <Route path={PATH.COMMUNITY} element={<CommunityPage />} />
                <Route
                  path={PATH.COMMUNITIYWRITING}
                  element={<WritingPage />}
                />
                <Route
                  path={PATH.COMMUNITIYPOSTING}
                  element={<PostingPage />}
                />
                <Route path={PATH.EDITCOMMUNITIY} element={<EditPostPage />} />
              </Route>

              <Route element={<LayoutCurrentMenuSearch />}>
                <Route path={PATH.FACILITIES} element={<FacilitiesPage />} />
                <Route
                  path={PATH.CATEGORY}
                  element={<FacilitiesPage mode="category" />}
                />
              </Route>
            </Routes>
          </AppPageGlobal>
        </Suspense>
      </div>
    </>
  );
}

export default App;
