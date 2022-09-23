import { FacilityPageGlobal } from '../styles/globalStyle/PageGlobalStyle';
import { FacilityDescGroup } from '../components/Group/BtnAndTagGroup';
import { H2, H3, H4 } from '../components/Text/Head';
import { TagGroup } from '../components/Group/BtnAndTagGroup';
import { ReviewCard } from '../components/Card/ReviewCard';
import { CReviewModal } from '../components/Modal/ReviewModal';
import { BigBtn } from '../components/Button/Btns';
import { CgWebsite } from 'react-icons/cg';
import { BiMap, BiBell } from 'react-icons/bi';
import { IoCallOutline } from 'react-icons/io5';
import { TbFileDescription } from 'react-icons/tb';
import { AiFillTag } from 'react-icons/ai';

import StarsCalc from '../components/Calculator/StarsCalc';
import { CarouselComponent } from '../components/Image/CarouselComponent';

import { ThemeProvider } from '@mui/material/styles';
import theme from '../styles/mui/theme';

//리뷰 수정페이지 : 아이콘 클릭하면 모달뜨게

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
      value: (
        <TagGroup backGround="bisque" margin="-4px 10px 13px 0px" tags={tags} />
      ),
      icon: <AiFillTag size="20" style={{ marginRight: '10px' }} />,
    },
    {
      idx: 6,
      value: '휴업',
      icon: <BiBell size="20" style={{ marginRight: '10px' }} />,
    },
  ];

  const imgs = [
    `https://img.shields.io/badge/-JavaScript-F7DF1E?style=flat-square&logo=JavaScript&logoColor=black`,
    `https://img.shields.io/badge/-TypeScript-3178C6?style=flat-square&logo=TypeScript&logoColor=white`,
  ];

  return (
    <>
      <FacilityPageGlobal>
        <ThemeProvider theme={theme}>
          <CarouselComponent imgs={imgs}>
            FacilityImage : http...경로로 불러오기
          </CarouselComponent>
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
            <BigBtn marginRight={'15px'}>찜</BigBtn>
            <BigBtn>내 시설 등록</BigBtn>
          </div>
          <div className="reviews--wrapper" style={{ marginTop: '30px' }}>
            <ReviewCard />
            <ReviewCard />
          </div>
          <div className="btns--wrapper" style={{ marginTop: '15px' }}>
            <CReviewModal />
          </div>
        </ThemeProvider>
      </FacilityPageGlobal>
    </>
  );
};

export default FacilityPage;
