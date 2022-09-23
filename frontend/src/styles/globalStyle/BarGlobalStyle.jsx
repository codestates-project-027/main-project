import styled from 'styled-components';

export const SearchbarGlobal = styled.div`
  display: flex;
  justify-content: center;
  align-items: center;
  width: 70%;
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
`;

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
  @media screen and (max-width: 790px) {
    display: flex;
  }
`;
