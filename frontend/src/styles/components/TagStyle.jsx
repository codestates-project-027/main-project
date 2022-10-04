import styled from 'styled-components';

export const TagStyle = styled.div`
  display: flex;
  background: ${(props) => props.backGround || '#fce46b'};
  padding: 5px 8px 5px 8px;
  border-radius: 8px;
  margin: ${(props) => props.margin || '7px'};
  cursor: pointer;
`;

