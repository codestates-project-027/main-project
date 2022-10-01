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
import { useParams } from 'react-router-dom';
import { useState, useEffect } from 'react';
import { useSelector } from 'react-redux';
import DistanceCalc from '../components/Calculator/DistanceCalc';

import StarsCalc from '../components/Calculator/StarsCalc';
import { CarouselComponent } from '../components/Image/CarouselComponent';

import { ThemeProvider } from '@mui/material/styles';
import theme from '../styles/mui/theme';
import axiosInstance from '../api/Interceptor';

const FacilityPage = () => {
  const { id } = useParams();
  const locationState = useSelector((state) => state.location);
  const [data, setData] = useState([
    {
      facilityId: 0,
      facilityName: '',
      facilityPhotoList: [],
      facilityInfo: '',
      address: '',
      website: '',
      phone: '',
      starRate: 0,
      location: '',
      categoryList: [],
    },
  ]);

  const getFacilityAXIOS = async () => {
    await axiosInstance.get('/facility/' + id).then((res) => setData(res.data));
  };

  useEffect(() => {
    getFacilityAXIOS();
  }, []);

  const tags = ['헬스', 'PT'];

  const facility = [
    {
      idx: 1,
      value: data.facilityInfo,
      icon: (
        <IconWrapperFac display="flex" alignItems="center" marginBottom="20px">
          <TbFileDescription size="20" />
        </IconWrapperFac>
      ),
    },
    {
      idx: 2,
      value: data.address,
      icon: (
        <IconWrapperFac display="flex" alignItems="center" marginBottom="20px">
          <BiMap size="20" />
        </IconWrapperFac>
      ),
    },
    {
      idx: 3,
      value: data.website,
      icon: (
        <IconWrapperFac display="flex" alignItems="center" marginBottom="20px">
          <CgWebsite size="20" />
        </IconWrapperFac>
      ),
    },
    {
      idx: 4,
      value: data.phone,
      icon: (
        <IconWrapperFac marginBottom="20px">
          <IoCallOutline size="20" />
        </IconWrapperFac>
      ),
    },
    {
      idx: 5,
      value: (
        <TagGroup backGround="#e4d5f8" margin="-4px 10px 13px 0px" tags={tags} />
      ),
      icon: (
        <IconWrapperFac>
          <AiFillTag size="20" />
        </IconWrapperFac>
      ),
    },
    {
      idx: 6,
      value: '영업 중',
      icon: (
        <IconWrapperFac>
          <BiBell size="20" />
        </IconWrapperFac>
      ),
    },
  ];

  const imgs = [
    //tags, imgs
    `https://img.shields.io/badge/-JavaScript-F7DF1E?style=flat-square&logo=JavaScript&logoColor=black`,
    `https://img.shields.io/badge/-TypeScript-3178C6?style=flat-square&logo=TypeScript&logoColor=white`,
  ];

  return (
    <>
      <FacilityPageGlobal>
        <ThemeProvider theme={theme}>
          <CarouselComponent imgs={imgs} />
          <div className="Fname--distance--wrapper">
            <H2 marginTop={'15px'}>{data.facilityName}</H2>
            <H4>
              <DistanceCalc
                currentLocation={locationState}
                facilityLocation={data.location}
              />
            </H4>
          </div>
          <div className="minimi--score--wrapper">
            {data.starRate === 0 ? (
              ''
            ) : (
              <>
                <H3>미니미 만족도</H3>
                <H4 marginLeft="15px">
                  <StarsCalc starValue={data.starRate} />
                </H4>
              </>
            )}
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
