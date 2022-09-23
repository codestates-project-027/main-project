import { SearchbarGlobal } from '../../styles/globalStyle/BarGlobalStyle';
import { IconWrapper } from '../../styles/components/IconStyles';
import { BiSearch } from 'react-icons/bi';
import styled from 'styled-components';

const Searchbar = () => {
  return (
    <>
      <SearchbarGlobal>
        <Input
          type="text"
          className="searchbar"
          placeholder="어떤 운동을 찾으세요?"
        />
        <IconWrapper marginRight={'13px'}>
          <BiSearch size="20" />
        </IconWrapper>
      </SearchbarGlobal>
    </>
  );
};

export default Searchbar;

const Input = styled.input`
  text-align: start;
`;
