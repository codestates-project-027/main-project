import './App.css';
import { useEffect, useState } from 'react';
import { Routes, Route } from 'react-router-dom';

// API Call
import api from './api/api-toEdit';

//GlobalStyles
import GlobalStyle from './styles/globalStyle/GlobalStyle';

//Layouts
import LayoutNoTopbar from './layouts/LayoutNoTopbar';

//Pages
import LoginPage from './pages/Login';
import SignUpPage from './pages/SignUp';

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
            </Route>
          </Routes>
        </GlobalStyle>
      </div>
    </>
  );
}

export default App;
