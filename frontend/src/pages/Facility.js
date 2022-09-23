//기능 구현 후 정리
import styled from 'styled-components';
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
import { IconWrapperFac } from '../styles/components/IconStyles';

import StarsCalc from '../components/Calculator/StarsCalc';
import { CarouselComponent } from '../components/Image/CarouselComponent';

import { ThemeProvider } from '@mui/material/styles';
import theme from '../styles/mui/theme';

const FacilityPage = () => {
  const tags = ['헬스', 'PT'];
  const facility = [
    {
      idx: 1,
      value: '소개 bla bla bla bla bla bla bla bla bla bla bla bla bla',
      icon: (
        <IconWrapperFac display="flex" alignItems="center" marginBottom="20px">
          <TbFileDescription size="20" />
        </IconWrapperFac>
      ),
    },
    {
      idx: 2,
      value: '주소',
      icon: (
        <IconWrapperFac display="flex" alignItems="center" marginBottom="20px">
          <BiMap size="20" />
        </IconWrapperFac>
      ),
    },
    {
      idx: 3,
      value: 'www.healthclub.com',
      icon: (
        <IconWrapperFac display="flex" alignItems="center" marginBottom="20px">
          <CgWebsite size="20" />
        </IconWrapperFac>
      ),
    },
    {
      idx: 4,
      value: '02-1111-1111',
      icon: (
        <IconWrapperFac marginBottom="20px">
          <IoCallOutline size="20" />
        </IconWrapperFac>
      ),
    },
    {
      idx: 5,
      value: (
        <TagGroup backGround="bisque" margin="-4px 10px 13px 0px" tags={tags} />
      ),
      icon: (
        <IconWrapperFac>
          <AiFillTag size="20" />
        </IconWrapperFac>
      ),
    },
    {
      idx: 6,
      value: '휴업',
      icon: (
        <IconWrapperFac>
          <BiBell size="20" />
        </IconWrapperFac>
      ),
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
            <H4 marginLeft="15px">
              <StarsCalc starValue={4} />
            </H4>
          </div>
          <FacilityDescGroup facility={facility} />

          <div className="btns--wrapper">
            <BigBtn marginRight="15px">찜</BigBtn>
            <BigBtn>내 시설 등록</BigBtn>
          </div>
          <Div className="reviews--wrapper" marginTop="30px">
            <ReviewCard />
            <ReviewCard />
          </Div>
          <Div className="btns--wrapper" marginTop="15px">
            <CReviewModal />
          </Div>
        </ThemeProvider>
      </FacilityPageGlobal>
    </>
  );
};

export default FacilityPage;

const Div = styled.div`
  margin-top: ${(props) => props.marginTop};
`;
