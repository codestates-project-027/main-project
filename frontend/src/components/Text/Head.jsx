import styled from 'styled-components';
import { Link } from 'react-router-dom';

export const H1 = styled.div`
  display: flex;
  margin-bottom: ${(props) => props.marginBottom};
  font-size: 1.5rem;
`;

export const H2 = styled(H1)`
  font-size: 1.3rem;
`;

export const H3 = styled(H1)`
  display: ${(props) => props.display};
  justify-content: ${(props) => props.justifyContent};
  font-size: 1.2rem;
  margin-top: ${(props) => props.marginTop};
  margin-bottom: ${(props) => props.marginBottom};
  @media screen and (max-width: ${(props) => props.maxWidth || '0'}) {
    display: none;
  }
`;

export const H4 = styled(H1)`
  //basic
  font-size: 1rem;
  align-items: ${(props) => props.alignItems || ''};
  margin-left: ${(props) => props.marginLeft || ''};
`;

export const H4Link = styled(Link)`
  font-size: 1rem;
  align-items: ${(props) => props.alignItems || ''};
  margin-left: ${(props) => props.marginLeft || ''};
`;
