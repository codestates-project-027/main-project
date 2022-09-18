import { FCardGlobal } from '../../styles/globalStyle/CardGlobalStyle';
import { FCardStyle } from '../../styles/components/CardStyle';

const FacilityCard = () => {
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

export default FacilityCard;
