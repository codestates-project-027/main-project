import styled from 'styled-components';

export const IconWrapper = styled.div`
  margin-left: ${(props) => props.marginLeft || '10px'};
  margin-right: ${(props) => props.marginRight || '0px'};
  cursor: pointer;
`;

export const IconWrapperFac = styled.div`
  margin-right: 10px;
  display: ${(props) => props.display};
  align-items: ${(props) => props.alignItems};
  margin-bottom: ${(props) => props.marginBottom};
`;

export const StarsWrapper = styled.div`
  margin-top: ${(props) => props.marginTop || '5px'};
`;

export const MainPageBtnIconStyle = styled.div`
  @media screen and (max-width: 3000px) {
    display: none;
  }

  @media screen and (max-width: 1097px) {
    display: flex;
  }
`;

export const BottomNavIconStyle = styled.div`
  display: flex;
  justify-content: space-around;
  align-items: center;
  margin-left: 1%;
  width: 55%;
  font-size: 1.8em;
`;

export const MarkerIconStyle = styled.div`
  display: flex;
  justify-content: center;
  align-items: center;
  width: 150px;
  height: 50px;
  background: #37474f;
  color: #fae316;
  border-radius: 3px;
`;
