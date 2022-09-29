import { SearchbarGlobal } from '../../styles/globalStyle/BarGlobalStyle';
import { IconWrapper } from '../../styles/components/IconStyles';
import { BiSearch } from 'react-icons/bi';
import styled from 'styled-components';
import { SearchbarGroupStyle } from '../../styles/components/ComponentGroupStyle';
import TextLogo from '../../assets/logo/minimi-text.png';
import { SquareBtn } from '../../components/Button/Btns';
import { StyledLink } from '../../styles/components/TextStyles';

export const Searchbar = ({ placeholder }) => {
  return (
    <>
      <SearchbarGlobal>
        <Input type="text" className="searchbar" placeholder={placeholder} />
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
      <StyledLink to="/">
        <Img alt="logo" src={TextLogo} />
      </StyledLink>
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
