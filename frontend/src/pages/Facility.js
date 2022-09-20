import { FacilityPageGlobal } from '../styles/globalStyle/PageGlobalStyle';
import { FacilityPageDescGroupStyle } from '../styles/components/ComponentGroupStyle';
import { H2, H3, H4 } from '../components/Text/Head';
import { CgWebsite } from 'react-icons/cg';
import { BiMap, BiBell } from 'react-icons/bi';
import { IoCallOutline } from 'react-icons/io5';

import StarsCalc from '../components/Calculator/StarsCalc';

const FacilityPage = () => {
  return (
    <>
      <FacilityPageGlobal>
        <div className="img--wrapper">
          FacilityImage : http...경로로 불러오기
        </div>
        <div className="Fname--distance--wrapper">
          <H2>OO동 헬스클럽</H2>
          <H4>0.3km</H4> {/*거리계산 컴포넌트*/}
        </div>
        <div className="minimi--score--wrapper">
          <H3>미니미 만족도</H3>
          <H4 style={{ marginLeft: '15px' }}>
            <StarsCalc starValue={4} />
          </H4>
        </div>
        <FacilityPageDescGroupStyle>
          {' '}
          {/*map 써서  줄이기 */}
          <H4>
            <BiMap size="20" style={{ marginRight: '10px' }} /> 주소
          </H4>
        </FacilityPageDescGroupStyle>
        <FacilityPageDescGroupStyle>
          <H4>
            <CgWebsite size="20" style={{ marginRight: '10px' }} />
            www.healthclub.com
          </H4>
        </FacilityPageDescGroupStyle>
        <FacilityPageDescGroupStyle>
          <H4>
            <IoCallOutline size="20" style={{ marginRight: '10px' }} />
            02-1111-1111
          </H4>
        </FacilityPageDescGroupStyle>
        <FacilityPageDescGroupStyle>
          <H4>
            <BiBell size="20" style={{ marginRight: '10px' }} /> 휴업
          </H4>
        </FacilityPageDescGroupStyle>
      </FacilityPageGlobal>
    </>
  );
};

export default FacilityPage;
