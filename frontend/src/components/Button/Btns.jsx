import styled from 'styled-components';
import { MainPageBtnIconStyle } from '../../styles/components/IconStyles';
import { MainPageBtnTextStyle } from '../../styles/components/TextStyles';

export const BasicBtn = styled.button`
  display: flex;
  justify-content: center;
  align-items: center;
  background: ${(props) => props.backGround || 'var(--main-yellow)'};
  color: ${(props) => props.color || 'var(--main-navy)'};
  width: ${(props) => props.width || 'fit-content'};
  height: ${(props) => props.height || 'fit-content'};
  border: none;
  border-radius: ${(props) => props.borderRadius || '3px'};
  padding: ${(props) => props.padding || '5px 8px 5px 8px'};
  margin-bottom: ${(props) => props.marginBottom || '0px'};
  box-shadow: 0px 2px 2px var(--box-shoadow);
  cursor: pointer;
  &:hover {
    background: ${(props) => props.hoverBg || 'var(--dark-yellow)'};
    box-shadow: 0px 2px 4px var(--hover-box-shadow);
    transition: all 0.3s ease-in-out;
  }
`;

export const RoundBtn = styled(BasicBtn)`
  width: ${(props) => props.width || '113px'};
  border-radius: ${(props) => props.borderRadius || '16px'};
  height: ${(props) => props.height || '43px'};
  margin-bottom: ${(props) => props.marginBottom || '15px'};
`;

export const SquareBtn = styled(BasicBtn)`
  background: var(--light-gray);
  width: ${(props) => props.wh || '40px'};
  height: ${(props) => props.wh || '40px'};
  border-radius: 3px;
  &:hover {
    background: var(--main-yellow);
  }
`;

export const QuickBtn = styled(SquareBtn)`
  width: ${(props) => props.wh || '70px'};
  height: ${(props) => props.wh || '70px'};
  font-size: 1rem;
  padding: 0;

  @media screen and (max-width: 3000px) {
    display: flex;
    background: var(--light-gray);
    &:hover {
      background: var(--light-gray);
    }
  }
  @media screen and (max-width: 1097px) {
    width: 60px;
    height: 60px;
  }

  @media screen and (max-width: 790px) {
    display: flex;
    width: 40px;
    height: 40px;
    margin: 5px;
  }
  @media screen and (max-width: 476px) {
    display: flex;
    width: 35px;
    height: 35px;
    margin: 0px;
  }
`;

export const MainQuickBtn = ({ iconProp, textProp }) => {
  return (
    <>
      <QuickBtn>
        <MainPageBtnIconStyle>{iconProp}</MainPageBtnIconStyle>
        <MainPageBtnTextStyle>{textProp}</MainPageBtnTextStyle>
      </QuickBtn>
    </>
  );
};

export const BigBtn = styled(BasicBtn)`
  
  padding: ${(props) => props.padding || '20px'};
  height: ${(props) => props.height || '35px'};
  margin-right: ${(props) => props.marginRight || '0px'};
  margin-left: ${(props) => props.marginLeft || '0px'};
  font-weight: ${(props) => props.fontWeight || '400'};
  font-size: ${(props) => props.fontSize};
  margin-top: ${(props) => props.marginTop};
  background: ${(props) => props.backGround};
  &:hover {
    background: ${(props) => props.hoverBg};
    color: ${(props) => props.hoverColor};
    font-weight: bold;
  }
`;

export const StickyBtn = styled(BasicBtn)`
  width: 57px;
  height: 57px;
  border-radius: 100%;
  position: fixed;
  bottom: 10%;
  right: 3%;
  word-break: break-all;
  white-space: pre;
  box-shadow: 24;
`;

export const Button = ({ onClick, children }) => {
  return <BigBtn onClick={onClick}>{children}</BigBtn>;
};

export const EditPostBtn = () => {
  return <button>수정</button>;
};

export const DeletePostBtn = () => {
  return <button>삭제</button>;
};
