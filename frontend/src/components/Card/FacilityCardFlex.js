import { FCardFlexGlobal } from '../../styles/globalStyle/CardGlobalStyle';
import { FCardFlexStyle } from '../../styles/components/CardStyle';

const FacilityCardFlex = () => {
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

export default FacilityCardFlex;
