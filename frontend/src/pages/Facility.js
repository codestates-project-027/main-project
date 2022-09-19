import { FacilityPageGlobal } from '../styles/globalStyle/PageGlobalStyle';
import { FacilityPageDescGroupStyle } from '../styles/components/ComponentGroupStyle';

const FacilityPage = () => {
  return (
    <>
      <FacilityPageGlobal>
        <div className="img--wrapper">
          FacilityImage : http...경로로 불러오기
        </div>
        <div className="Fname--distance--wrapper">
          <div className="Fname">OO동 헬스클럽</div>
          <div className="distance">0.3km</div>
        </div>
        <div className="minimi--score--wrapper">
          <div className="score--name">미니미 만족도</div>
          <div className="stars">별 별 별</div>
        </div>
        <FacilityPageDescGroupStyle>
          {' '}
          {/*map 써서 3줄로 줄이기 */}
          <span>주소 아이콘 주소</span>
        </FacilityPageDescGroupStyle>
        <FacilityPageDescGroupStyle>
          <span> 홈페이지 아이콘 www.healthclub.com</span>
        </FacilityPageDescGroupStyle>
        <FacilityPageDescGroupStyle>
          <span>전화 아이콘 02-1111-1111</span>
        </FacilityPageDescGroupStyle>
        <FacilityPageDescGroupStyle>
          <span> bell 아이콘금일 휴업</span>
        </FacilityPageDescGroupStyle>
      </FacilityPageGlobal>
    </>
  );
};

export default FacilityPage;
