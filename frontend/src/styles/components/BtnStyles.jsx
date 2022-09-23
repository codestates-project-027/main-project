import styled from 'styled-components';
import { PADDING } from '../../constants/style';

export const SubmitBtnStyle = styled.div`
  background: var(--main-yellow);
  display: flex;
  justify-content: center;
  align-items: center;
  padding: ${PADDING.BASIC};
  width: fit-content;
  height: 35px;
  border-radius: 5px;
  margin-right: 10px;
`;

export const DeleteBtnStyle = styled(SubmitBtnStyle)`
  background: black;
  color: red;
  font-weight: 700;
`;

export const StickyBtnStyle = styled.div`
  display: flex;
  justify-content: center;
  align-items: center;
  background: var(--logo-yellow);
  width: 57px;
  height: 57px;
  border-radius: 100%;
  position: sticky;
  margin-bottom: 30px;
  margin-right: -90%;
  word-break: break-all;
  white-space: pre;
  box-shadow: 24;
`;
