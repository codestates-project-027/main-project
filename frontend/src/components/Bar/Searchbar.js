import styled from 'styled-components';
import { BiSearch, BiMap } from 'react-icons/bi';
import SquareBtn from '../Button/SquareBtn';

const Searchbar = () => {
  return (
    <>
      <SearchbarStyle>
        <input
          type="text"
          className="searchbar"
          placeholder="어떤 운동을 찾으세요?"
        />
        <BiSearch style={IconStyle} size="20" />
      </SearchbarStyle>
      <SquareBtn>
        <BiMap size="20" />
      </SquareBtn>
    </>
  );
};

export default Searchbar;

const SearchbarStyle = styled.div`
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

const IconStyle = {
  marginRight: '13px',
  cursor: 'pointer',
};
