import styled from 'styled-components';

export const H1 = styled.div`
  display: flex;
  font-size: 1.5rem;
`;

export const H2 = styled(H1)`
  font-size: 1.3rem;
`;

export const H3 = styled(H1)`
  font-size: 1.2rem;
`;

export const H3Vainish = styled(H3)`
  @media screen and (max-width: 790px) {
    display: none;
  }
`;

export const H4 = styled(H1)`
  //basic
  font-size: 1rem;
  align-items: ${(props) => props.alignItems || ''};
`;