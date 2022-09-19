import './App.css';
import { useEffect, useState } from 'react';
import { Routes, Route } from 'react-router-dom';
import Test from './Test';

// API Call
import api from './api/api-toEdit';

//GlobalStyles
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
import LocationPage from './pages/Location';

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
              <Route path="/login" element={<LoginPage />} />
              <Route path="/signup" element={<SignUpPage />} />
              <Route path="/test" element={<Test />} /> {/*삭제*/}
            </Route>

            <Route element={<LayoutMain />}>
              <Route path="/" element={<MainPage />} />
            </Route>

            <Route element={<LayoutCurrentMenu />}>
              <Route path="/facility" element={<FacilityPage />} />
              <Route path="/mypage" element={<MyPage />} />
              <Route path="/alarms" element={<AlarmsPage />} />
              <Route path="/location" element={<LocationPage />} />
            </Route>

            <Route element={<LayoutCurrentMenuSearch />}>
              <Route path="/facilities" element={<FacilitiesPage />} />
            </Route>
          </Routes>
        </GlobalStyle>
      </div>
    </>
  );
}

export default App;
