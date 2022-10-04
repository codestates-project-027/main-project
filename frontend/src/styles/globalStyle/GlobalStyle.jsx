import { createGlobalStyle } from 'styled-components';

const GlobalStyle = createGlobalStyle`
  * {
    margin: 0;
    padding: 0;
    box-sizing: border-box;
    text-align: center;
    font-family: 'nanumsquare';
    --main-yellow: #ffeb3b;
    --logo-yellow: #fae316;
    /* --light-yellow: #ffff72; */
    --dark-yellow: #f5e131;

    --box-shoadow: #bdbdbd;
    --hover-box-shadow: #a1a1a1;
    --main-navy: #37474f;
    --light-navy: #62727b;
    --dark-navy: #102027;
    --attended: lightgreen;
    --absent: lightgray;
    --light-gray: rgb(240, 240, 240);
  }

  div{color:#37474f;}

  li {
    list-style: none;
  }

  a {
    text-decoration: none;
    color:#37474f;
  }

  button {
    cursor: pointer;
  }
`;

export default GlobalStyle;
