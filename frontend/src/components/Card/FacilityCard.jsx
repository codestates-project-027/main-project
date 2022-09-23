import {
  FCardGlobal,
  FCardFlexGlobal,
} from '../../styles/globalStyle/CardGlobalStyle';

import {
  FCardStyle,
  FCardFlexStyle,
  FDescCardStyle,
} from '../../styles/components/CardStyle';

import { BigBtn } from '../../components/Button/Btns';
import { H4 } from '../Text/Head';

export const FBaseCard = () => {
  return (
    <>
      <div className="img--wrapper">img</div>
      <div className="content--wrapper">
        <div className="name--wrapper">
          <H4>name</H4>
          <div className="distance">distance</div>
        </div>
        <div className="score--wrapper">
          <div className="score">미니미만족도</div>
          <div className="stars">별 갯수</div>
        </div>
        <div className="tag--wrapper">
          <div className="tags">tags</div>
        </div>
      </div>
    </>
  );
};

export const FacilityCard = () => {
  return (
    <>
      <FCardGlobal to="/facility">
        <FCardStyle>
          <FBaseCard />
        </FCardStyle>
      </FCardGlobal>
    </>
  );
};

export const FacilityCardFlex = () => {
  return (
    <>
      <FCardFlexGlobal to="/facility">
        <FCardFlexStyle>
          <FBaseCard />
        </FCardFlexStyle>
      </FCardFlexGlobal>
    </>
  );
};

export const FacilityDescCard = ({ text, backGround, color }) => {
  return (
    <>
      <FDescCardStyle>
        <H4 alignItems="center">OO동 헬스클럽</H4>
        <BigBtn backGround={backGround} color={color}>
          {text}
        </BigBtn>
      </FDescCardStyle>
    </>
  );
};
