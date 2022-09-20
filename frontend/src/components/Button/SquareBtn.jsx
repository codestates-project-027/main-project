import styled from 'styled-components';

const SquareBtn = styled.div`
  display: flex;
  align-items: center;
  justify-content: center;
  width: 40px;
  height: 40px;
  background: var(--light-gray);
  border-radius: 3px;
  cursor: pointer;
  &:hover {
    background: var(--main-yellow);
  }
`;

export default SquareBtn;
