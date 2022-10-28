import './App.css';
import { Suspense, useState, useEffect } from 'react';
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
  const [fin, setFin] = useState(false);
  const [city, setCity] = useState('');
  //facility
  const [data, setData] = useState([
    {
      facilityId: 0,
      facilityName: '',
      facilityPhotoList: [],
      facilityInfo: '',
      address: '',
      website: '',
      phone: '',
      starRate: 0,
      location: '',
      categoryList: [],
    },
  ]);

  return (
    <>
      <div className="App">
        <Suspense fallback={<CircularIndeterminate />}>
          <AppPageGlobal>
            <Routes>
              <Route element={<LayoutBase fin={fin} setFin={setFin} />}>
                <Route path={PATH.TEST} element={<TestPage />} />
                <Route path={PATH.SIGNUP} element={<SignUpPage />} />
                <Route path={PATH.LOGIN} element={<LoginPage />} />
              </Route>

              <Route element={<LayoutMain city={city} />}>
                <Route path={PATH.MAIN} element={<MainPage />} />
              </Route>

              <Route element={<LayoutCurrentMenu data={data}/>}>
                <Route
                  path={PATH.MYPAGE}
                  element={<MyPage fin={fin} setFin={setFin} />}
                />
                <Route
                  path={PATH.FACILITY}
                  element={<FacilityPage fin={fin} setFin={setFin} data={data} setData={setData} />}
                />
                <Route
                  path={PATH.REGISTERFACILITY}
                  element={<RegisterFacilityPage fin={fin} setFin={setFin} />}
                />
                <Route
                  path={PATH.EDITFACILITY}
                  element={<EditFacilityPage fin={fin} setFin={setFin} />}
                />

                <Route
                  path={PATH.MAP}
                  element={
                    <MapPage
                      fin={fin}
                      setFin={setFin}
                      setCity={setCity}
                      city={city}
                    />
                  }
                />
                <Route path={PATH.ALARMS} element={<AlarmsPage />} />

                <Route
                  path={PATH.ADMIN}
                  element={<AdminPage fin={fin} setFin={setFin} />}
                />
              </Route>

              <Route
                element={<LayoutCurrentMenuSearch fin={fin} setFin={setFin} />}
              >
                <Route
                  path={PATH.FACILITIES}
                  element={<FacilitiesPage fin={fin} setFin={setFin} />}
                />
                <Route
                  path={PATH.CATEGORY}
                  element={
                    <FacilitiesPage mode="category" fin={fin} setFin={setFin} />
                  }
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
            </Routes>
          </AppPageGlobal>
        </Suspense>
      </div>
    </>
  );
}

export default App;
