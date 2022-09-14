import axios from 'axios';

// const BASE_URL = `http://ec2-43-200-169-36.ap-northeast-2.compute.amazonaws.com:8080`;
const BASE_URL = `http://localhost:8080`;

// url
const API = {
  TEST: `${BASE_URL}/home`,
};

// axios
const Test = {
  get: async () => {
    try {
      const { data } = await axios(API.TEST);
      return data;
    } catch (err) {
      if (err.response) {
        alert(err.response);
      }
    }
  },
};

export default { BASE_URL, API, Test };
