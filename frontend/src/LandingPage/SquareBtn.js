import styled from 'styled-components';
import { BiMap } from 'react-icons/bi';

const SquareBtn = () => {
  return (
    <>
      <BtnStyle>
        <BiMap size="20" />
      </BtnStyle>
    </>
  );
};

export default SquareBtn;

const BtnStyle = styled.div`
  display: flex;
  align-items: center;
  justify-content: center;
  width: 40px;
  height: 40px;
  background: rgb(240, 240, 240);
  border-radius: 3px;
  cursor: pointer;
  &:hover {
    background-color: var(--main-yellow);
  }
`;
