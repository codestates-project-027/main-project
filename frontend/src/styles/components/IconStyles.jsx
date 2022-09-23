import styled from 'styled-components';

export const IconWrapper = styled.div`
  margin-left: ${(props) => props.marginLeft || '10px'};
  cursor: pointer;
`;

export const IconStyle = {
  //이름 바꾸기
  marginRight: '13px',
  cursor: 'pointer',
};

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

export const MarkerIconStyle = {
  display: 'flex',
  justifyContent: 'center',
  alignItems: 'center',
  width: '150px',
  height: '50px',
  background: '#37474f',
  color: '#fae316',
  borderRadius: '3px',
};
