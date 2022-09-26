import styled from 'styled-components';

export const TagStyle = styled.div`
  display: flex;
  background: ${(props) => props.backGround || 'aliceblue'};
  padding: 5px 8px 5px 8px;
  border-radius: 8px;
  margin: ${(props) => props.margin || '7px'};
`;

