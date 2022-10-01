import styled from 'styled-components';
import { Link } from 'react-router-dom';

export const FCardGlobal = styled.div`
  display: flex;
  align-items: center;
  margin: 8px;
  width: 37%;
  height: 20%;
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

export const MCardFlexGlobal = styled(MCardGlobal)`
  @media screen and (min-width: 790px) {
    display: flex;
  }
`;

export const AlarmCardGlobal = styled.div`
  display: flex;
  justify-content: center;
  align-items: center;
  width: 100%;
`;

export const ReviewCardGlobal = styled.div`
  display: flex;
  background: lightgreen;
  margin-bottom: 10px;
`;

export const CommunityCardGlobal = styled.div`
  display: flex;
  align-items: center;
  width: 600px;
  height: 100px;
  color: yellow;
  font-size: 10px;
  background-color: var(--main-navy);
  border-radius: 10px;
`;
