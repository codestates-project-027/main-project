import styled from 'styled-components';
import { PADDING } from '../../constants/style';

export const SearchbarGroupStyle = styled.div`
  display: flex;
  justify-content: center;
  width: ${(props) => props.width || '100%'};
  margin: ${(props) => props.margin};
  @media screen and (max-width: 790px) {
    width: 80%;
    margin: ${props=>props.mmargin};
    .hide {
      display: none;
    }
    .icon {
      margin-left: 15px;
    }
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
    font-size: 1.2rem;
    text-align: left;
    margin-top: 30px;
    margin-bottom: 15px;
    padding: 5px;
    @media screen and (max-width: 790px) {
      display: none;
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

export const MainPageBIGroupStyle = styled.div`
  //button & icon group
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
`;

export const FacilityPageDescGroupStyle = styled.div`
  display: flex;
  padding: ${PADDING.BASIC};
  background-color: #f3f3f3; //#def5fb
  flex-direction: column;
  justify-content: center;
`;
