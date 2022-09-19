import styled from 'styled-components';
import { PADDING } from '../../constants/style';

export const SearchbarGroupStyle = styled.div`
  display: flex;
  justify-content: center;
  align-items: center;
  width: 60%;
  @media screen and (max-width: 790px) {
    width: 80%;
  }
`;

export const MainPageBtnsGroupStyle = styled.div`
  display: flex;
  flex-direction: column;
  margin-left: 60px;
  width: 42%;
  /* background: black; */

  @media screen and (max-width: 790px) {
    width: 50%;
  }
  .menu--title {
    font-size: 15px;
    text-align: left;
    margin-top: 30px;
    margin-bottom: 15px;
    padding: 5px;
    @media screen and (max-width: 790px) {
      display: none;
    }
  }
  .menu--icons--wrapper {
    display: flex;
    align-items: center;
    justify-content: space-evenly;
    flex-wrap: wrap;

    @media screen and (min-width: 1098px) {
      height: 150px;
    }
    @media screen and (max-width: 1097px) {
      height: 100px;
    }
  }

  @media screen and (max-width: 1097px) {
    margin-top: 5px;
    margin-left: 35px;
  }

  @media screen and (max-width: 875px) {
    margin-top: 5px;
    margin-left: 25px;
  }

  @media screen and (max-width: 790px) {
    margin-top: 5px;
    margin-left: -15px;
  }
`;

export const FacilityPageDescGroupStyle = styled.div`
  display: flex;
  padding: ${PADDING.BASIC};
  background-color: aliceblue;
  flex-direction: column;
  span {
    color: red;
    display: flex;
  }
`;
