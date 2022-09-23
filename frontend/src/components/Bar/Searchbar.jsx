import { SearchbarGlobal } from '../../styles/globalStyle/BarGlobalStyle';
import { IconWrapper } from '../../styles/components/IconStyles';
import { BiSearch } from 'react-icons/bi';
import styled from 'styled-components';
import { SearchbarGroupStyle } from '../../styles/components/ComponentGroupStyle';
import TextLogo from '../../assets/logo/minimi-text.png';
import { SquareBtn } from '../../components/Button/Btns';

export const Searchbar = () => {
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

export const SearchbarWBtn = ({ Icon, noIcon }) => {
  return (
    <SearchbarGroupStyle margin="30px">
      <Img alt="logo" src={TextLogo} />
      <Searchbar />
      {noIcon ? null : <SquareBtn>{Icon}</SquareBtn>}
    </SearchbarGroupStyle>
  );
};

const Input = styled.input`
  text-align: start;
`;

const Img = styled.img`
  width: 70px;
`;
