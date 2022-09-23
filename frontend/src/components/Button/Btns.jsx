import styled from 'styled-components';

export const BasicBtn = styled.div`
  display: flex;
  justify-content: center;
  align-items: center;
  background: ${(props) => props.backGround || '#FFEB3B'};
  color: ${(props) => props.color || '#37474f'};
  width: ${(props) => props.width || 'fit-content'};
  height: ${(props) => props.height || 'fit-content'};
  border: none;
  border-radius: ${(props) => props.borderRadius || '3px'};
  padding: 5px;
  padding-left: 8px;
  padding-right: 8px;
  margin-bottom: ${(props) => props.marginBottom || '0px'};
  box-shadow: 0px 2px 2px #bdbdbd;
  cursor: pointer;
  &:hover {
    background: ${(props) => props.hoverBg || '#f5e131'};
    box-shadow: 0px 2px 4px #a1a1a1;
    transition: all 0.3s ease-in-out;
  }
`;

export const RoundBtn = styled(BasicBtn)`
  width: ${(props) => props.width || '113px'};
  border-radius: ${(props) => props.borderRadius || '16px'};
  height: ${(props) => props.height || '43px'};
  margin-bottom: ${(props) => props.marginBottom || '15px'};
`;
