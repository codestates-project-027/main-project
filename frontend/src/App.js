import './App.css';
import { useEffect, useState } from 'react';
import { Routes, Route } from 'react-router-dom';
import Test from './Test';

//API Call
import api from './api/api-toEdit';

//Routes
import PATH from './routes/routePath';

//GlobalStyle
import GlobalStyle from './styles/globalStyle/GlobalStyle';

//Layouts
import {
  LayoutMain,
  LayoutCurrentMenu,
  LayoutCurrentMenuSearch,
} from './layouts/LayoutTopbars';
import LayoutNoTopbar from './layouts/LayoutNoTopbar';

//Pages
import LoginPage from './pages/Login';
import SignUpPage from './pages/SignUp';
import MainPage from './pages/Main';
import FacilityPage from './pages/Facility';
import FacilitiesPage from './pages/Facilities';
import MyPage from './pages/MyPage';
import AlarmsPage from './pages/Alarms';
import MapPage from './pages/Map';

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
        <GlobalStyle>
          <Routes>
            <Route element={<LayoutNoTopbar />}>
              <Route path={PATH.TEST} element={<Test />} /> {/*삭제*/}
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
              {/* 시설 등록 페이지 */}
            </Route>

            <Route element={<LayoutCurrentMenuSearch />}>
              <Route path={PATH.FACILITIES} element={<FacilitiesPage />} />
            </Route>
          </Routes>
        </GlobalStyle>
      </div>
    </>
  );
}

export default App;
