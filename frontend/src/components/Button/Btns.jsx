import styled from 'styled-components';

export const BasicBtn = styled.div`
  background: ${(props) => props.backGround || '#fae316'};
  color: ${(props) => props.color || '#37474f'};
  width: ${(props) => props.width || 'fit-content'};
  height: ${(props) => props.height || 'fit-content'};
  border: none;
  border-radius: 3px;
  padding: 5px;
  padding-left: 8px;
  padding-right: 8px;
  cursor: pointer;
`;
