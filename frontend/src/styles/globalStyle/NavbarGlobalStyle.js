import styled from 'styled-components';

export const BottomNavbarGlobal = styled.div`
  display: flex;
  justify-content: center;
  align-items: center;
  height: 8vh;
  width: 100%;
  background-color: var(--main-yellow);
`;

export const TopNavbarGlobal = styled(BottomNavbarGlobal)`
  display: none;
  justify-content: center;
  align-items: center;
  height: 8vh;
  width: 100%;
  background-color: var(--main-yellow);
  @media screen and (max-width: 790px) {
    display: flex;
  }
`;
