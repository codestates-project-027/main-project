import styled from 'styled-components';
import { Link } from 'react-router-dom';

export const FCardGlobal = styled(Link)`
  display: flex;
  align-items: center;
  margin: 8px;
  width: 37%;
  height: 20%;
  background-color: aliceblue;
  text-decoration: none;

  @media screen and (max-width: 3000px) {
    display: flex;
  }

  @media screen and (max-width: 790px) {
    display: none;
  }
`;

export const FCardFlexGlobal = styled(FCardGlobal)`
  @media screen and (max-width: 790px) {
    display: flex;
    width: 250px;
  }
`;

export const MCardGlobal = styled.div`
  display: none;
  justify-content: center;
  align-items: center;
  width: 350px;
  height: 200px;
  background-color: var(--main-navy);
  color: wheat;
  margin-top: 50px;
  margin-bottom: 50px;
  border-radius: 5px;
  @media screen and (max-width: 790px) {
    //429px
    display: flex;
  }
`;
