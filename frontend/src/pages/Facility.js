import { FacilityPageGlobal } from '../styles/globalStyle/PageGlobalStyle';
import { FacilityDescGroup } from '../components/Group/BtnAndTagGroup';
import { H2, H3, H4 } from '../components/Text/Head';

import { CgWebsite } from 'react-icons/cg';
import { BiMap, BiBell } from 'react-icons/bi';
import { IoCallOutline } from 'react-icons/io5';

import StarsCalc from '../components/Calculator/StarsCalc';

const FacilityPage = () => {
  const facility = [
    {
      idx: 1,
      value: '주소',
      icon: (
        <BiMap
          size="20"
          style={{ marginRight: '10px', marginBottom: '20px' }}
        />
      ),
    },
    {
      idx: 2,
      value: 'www.healthclub.com',
      icon: (
        <CgWebsite
          size="20"
          style={{ marginRight: '10px', marginBottom: '20px' }}
        />
      ),
    },
    {
      idx: 3,
      value: '02-1111-1111',
      icon: (
        <IoCallOutline
          size="20"
          style={{ marginRight: '10px', marginBottom: '20px' }}
        />
      ),
    },
    {
      idx: 4,
      value: '휴업',
      icon: (
        <BiBell
          size="20"
          style={{ marginRight: '10px' }}
        />
      ),
    },
  ];

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
        <FacilityDescGroup facility={facility} />
      </FacilityPageGlobal>
    </>
  );
};

export default FacilityPage;
