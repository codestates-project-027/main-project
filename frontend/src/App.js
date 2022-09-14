import './App.css';
import { useEffect, useState } from 'react';
import { Routes, Route } from 'react-router-dom';
import styled from 'styled-components';

import Navbar from './LandingPage/Navbar';

import LandingPage from './LandingPage/LandingPage';
import LoginPage from './pages/LoginPage';

// API Call
import api from './api/api.js';

function App() {
  const [test, setTest] = useState('');

  const getData = () => {
    api.Test.get().then((data) => {
      // if (data.status !== 200) {
      //   alert(data.status);
      // } else {
      setTest(data);
      // }
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
          <RoutesWrapper>
            <Routes>
              <Route path="/" element={<LandingPage />} />
              <Route path="/login" element={<LoginPage />} />
            </Routes>
          </RoutesWrapper>
          <NavbarWrapper>
            <Navbar />
          </NavbarWrapper>
        </GlobalStyle>
      </div>
    </>
  );
}

export default App;

const GlobalStyle = styled.div`
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;

  @media screen and (max-width: 900px) {
    //pad
    color: bisque;
  }

  @media screen and (max-width: 400px) {
    //mobile
    color: red;
  }
`;

const RoutesWrapper = styled.div`
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
  height: 92vh;
  width: 100%;
  /* background-color: var(--main-yellow-color); */
`;

const NavbarWrapper = styled.div`
  display: flex;
  justify-content: center;
  align-items: center;
  height: 8vh;
  width: 100%;
  background-color: var(--main-yellow);
`;
