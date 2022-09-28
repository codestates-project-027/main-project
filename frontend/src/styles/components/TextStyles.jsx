import styled from 'styled-components';
import { Link } from 'react-router-dom';

export const MainPageBtnTextStyle = styled.div`
  word-break: keep-all;
  @media screen and (max-width: 3000px) {
    display: flex;
  }

  @media screen and (max-width: 1097px) {
    display: none;
  }
`;

export const StyledLink = styled(Link)`
  text-decoration: none;
`;
