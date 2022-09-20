import { FacilityPageGlobal } from '../styles/globalStyle/PageGlobalStyle';
import { FacilityPageDescGroupStyle } from '../styles/components/ComponentGroupStyle';
import { H2, H3, H4 } from '../components/Text/Head';

const FacilityPage = () => {
  return (
    <>
      <FacilityPageGlobal>
        <div className="img--wrapper">
          FacilityImage : http...경로로 불러오기
        </div>
        <div className="Fname--distance--wrapper">
          <H2>OO동 헬스클럽</H2>
          <H4>0.3km</H4>
        </div>
        <div className="minimi--score--wrapper">
          <H3>미니미 만족도</H3>
          <H4 style={{ marginLeft: '15px' }}>별 별 별</H4>
        </div>
        <FacilityPageDescGroupStyle>
          {' '}
          {/*map 써서  줄이기 */}
          <H4>주소 아이콘 주소</H4>
        </FacilityPageDescGroupStyle>
        <FacilityPageDescGroupStyle>
          <H4> 홈페이지 아이콘 www.healthclub.com</H4>
        </FacilityPageDescGroupStyle>
        <FacilityPageDescGroupStyle>
          <H4>전화 아이콘 02-1111-1111</H4>
        </FacilityPageDescGroupStyle>
        <FacilityPageDescGroupStyle>
          <H4> bell 아이콘금일 휴업</H4>
        </FacilityPageDescGroupStyle>
      </FacilityPageGlobal>
    </>
  );
};

export default FacilityPage;
