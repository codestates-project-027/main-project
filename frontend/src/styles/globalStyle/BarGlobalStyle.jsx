import styled from 'styled-components';

export const SearchbarGlobal = styled.div`
  display: flex;
  justify-content: center;
  align-items: center;
  width: 93%;
  height: 43px;
  border-radius: 3px;
  margin-left: 20px;
  margin-right: 20px;
  border: 1px solid lightgray;
  > input.searchbar {
    margin-left: 13px;
    padding: 4px 0 0 0;
    flex: 1 auto !important;
    width: 85%;
    border: none;
    color: var(--main-navy);
    &::placeholder {
      opacity: 0.6;
    }
    :focus {
      outline: transparent;
    }
  }
  &:focus-within {
    border: 1.5px solid var(--logo-yellow);
  }
  .delete {
    cursor: pointer;
  }
  @media screen and (max-width: 476px) {
    display: flex;
    justify-content: center;
    /* margin-left: ${(props) => props.marginLeft || '-15px'}; */
    /* width: ${(props) => props.width || '350px'}; */
    width: 99%;
  }
`;

export const BottomNavbarGlobal = styled.div`
  position: fixed;
  bottom: 0;
  left: 0;
  right: 0;
  display: flex;
  justify-content: center;
  align-items: center;
  height: 70px;
  width: 100%;
  background-color: var(--main-yellow);
  z-index: 20;
`;

export const TopNavbarGlobal = styled.div`
  position: fixed;
  display: none;
  margin-top: -40px;
  justify-content: space-between;
  align-items: center;
  height: 70px;
  width: 100%;
  background-color: var(--main-yellow);
  z-index: 20;
  .tab--wrapper {
    display: flex;
    margin-left: 20px;
  }
  .icon--wrapper {
    margin-right: 20px;
  }
  @media screen and (max-width: 790px) {
    display: flex;
  }
`;

export const CommunityTopNavbarGlobal = styled(BottomNavbarGlobal)`
  display: none;
  justify-content: space-between;
  align-items: center;
  height: 8vh;
  width: 100%;
  background-color: var(--main-yellow);
  .tab--wrapper {
    display: flex;
    margin-left: 20px;
  }
  .icon--wrapper {
    margin-right: 20px;
  }
  @media screen {
    display: flex;
  }
`;
