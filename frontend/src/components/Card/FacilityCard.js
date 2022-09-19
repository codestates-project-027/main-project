import {
  FCardGlobal,
  FCardFlexGlobal,
} from '../../styles/globalStyle/CardGlobalStyle';
import {
  FCardStyle,
  FCardFlexStyle,
  FDescCardStyle,
} from '../../styles/components/CardStyle';

export const FacilityCard = () => {
  return (
    <>
      <FCardGlobal to="/facility">
        <FCardStyle>
          <div className="img--wrapper">img</div>
          <div className="content--wrapper">
            <div className="name--wrapper">
              <div className="name">name</div>
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
          <div className="img--wrapper">img</div>
          <div className="content--wrapper">
            <div className="name--wrapper">
              <div className="name">name</div>
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
        </FCardFlexStyle>
      </FCardFlexGlobal>
    </>
  );
};

export const FacilityDescCard = () => {
  return (
    <>
      <FDescCardStyle>
        <div className="Fname">OO동 헬스클럽</div>
        <div className="remaining">남은 기간</div>
      </FDescCardStyle>
    </>
  );
};
