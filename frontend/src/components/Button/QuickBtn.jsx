import SquareBtn from './SquareBtn';
import styled from 'styled-components';
import { MainPageBtnIconStyle } from '../../styles/components/IconStyles';
import { MainPageBtnTextStyle } from '../../styles/components/TextStyles';

export const QuickBtn = styled(SquareBtn)`
  display: flex;
  width: 70px;
  height: 70px;
  font-size: 1rem;

  @media screen and (max-width: 3000px) {
    display: flex;
    background: var(--light-gray);
    &:hover {
      /* color: var(--logo-yellow); */
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
        <MainPageBtnIconStyle>
          {iconProp}
        </MainPageBtnIconStyle>
        <MainPageBtnTextStyle>{textProp}</MainPageBtnTextStyle>
      </QuickBtn>
    </>
  );
};
