import { FacilityPageGlobal } from '../styles/globalStyle/PageGlobalStyle';
import { FacilityDescGroup } from '../components/Group/BtnAndTagGroup';
import { H2, H3, H4 } from '../components/Text/Head';
import { SubmitBtn } from '../components/Button/SubmitBtn';
import { TagGroupDesc } from '../components/Group/BtnAndTagGroup';
import { ReviewCard } from '../components/Card/ReviewCard';

import { CgWebsite } from 'react-icons/cg';
import { BiMap, BiBell } from 'react-icons/bi';
import { IoCallOutline } from 'react-icons/io5';
import { TbFileDescription } from 'react-icons/tb';
import { AiFillTag } from 'react-icons/ai';

import StarsCalc from '../components/Calculator/StarsCalc';

//이미지 캐러셀
//시설 소개글 n줄
//카테고리 생성...??
//운동시설 생성페이지, 수정페이지, 삭제기능
//리뷰 생성,수정 페이지

const FacilityPage = () => {
  const tags = ['헬스', 'PT'];
  const facility = [
    {
      idx: 1,
      value: '소개 bla bla bla bla bla bla bla bla bla bla bla bla bla',
      icon: (
        <TbFileDescription
          size="20"
          style={{
            display: 'flex',
            alignItems: 'center',
            marginRight: '10px',
            marginBottom: '20px',
          }}
        />
      ),
    },
    {
      idx: 2,
      value: '주소',
      icon: (
        <BiMap
          size="20"
          style={{
            display: 'flex',
            alignItems: 'center',
            marginRight: '10px',
            marginBottom: '20px',
          }}
        />
      ),
    },
    {
      idx: 3,
      value: 'www.healthclub.com',
      icon: (
        <CgWebsite
          size="20"
          style={{ marginRight: '10px', marginBottom: '20px' }}
        />
      ),
    },
    {
      idx: 4,
      value: '02-1111-1111',
      icon: (
        <IoCallOutline
          size="20"
          style={{ marginRight: '10px', marginBottom: '20px' }}
        />
      ),
    },
    {
      idx: 5,
      value: <TagGroupDesc tags={tags} />,
      icon: <AiFillTag size="20" style={{ marginRight: '10px' }} />,
    },
    {
      idx: 6,
      value: '휴업',
      icon: <BiBell size="20" style={{ marginRight: '10px' }} />,
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

        <div className="btns--wrapper">
          <SubmitBtn text={'찜'} />
          <SubmitBtn text={'내 시설 등록'} />
        </div>
        <div className="reviews--wrapper" style={{ marginTop: '30px' }}>
          <ReviewCard />
          <ReviewCard />
        </div>
        <div className="btns--wrapper" style={{ marginTop: '15px' }}>
          <SubmitBtn text={'리뷰 작성'} />
        </div>
      </FacilityPageGlobal>
    </>
  );
};

export default FacilityPage;
