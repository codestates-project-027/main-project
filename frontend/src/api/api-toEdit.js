//수정해야 함
import axios from 'axios';

// const BASE_URL = `https://minimi-place.duckdns.org`;
const BASE_URL = `http://localhost:8080`;

// url
const API = {
  HOME: `${BASE_URL}/home`,
};

// axios
const Test = {
  get: async () => {
    try {
      const { data } = await axios(API.HOME);
      return data;
    } catch (err) {
      if (err.response) {
        alert(err.response);
      }
    }
  },
};

export default { BASE_URL, API, Test };
