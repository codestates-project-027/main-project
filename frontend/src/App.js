import './App.css';
import { useEffect, useState } from 'react';

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

  return (
    <>
      <div className="App">
        App page
        {console.log(test)}
      </div>
    </>
  );
}

export default App;
