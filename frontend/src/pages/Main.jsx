import { useEffect, useState, useCallback } from 'react';
import { Link } from 'react-router-dom';
import { useSelector, useDispatch } from 'react-redux';
import { SearchbarWBtn } from '../components/Bar/Searchbar';

import { FacilityCard } from '../components/Card/FacilityCard';
import { MemberCard } from '../components/Card/MemberCard';
import { MainPageGlobal } from '../styles/globalStyle/PageGlobalStyle';
import { MainPageBtnsGroupStyle } from '../styles/components/ComponentGroupStyle';
import { MainQuickBtnGroup } from '../components/Group/BtnAndTagGroup';
import { StyledLink } from '../styles/components/TextStyles';
import axiosInstance from '../api/Interceptor';
import { getCategory } from '../redux/slices/categorySlice';

//icons
import { IoIosFitness } from 'react-icons/io';
import { GrYoga } from 'react-icons/gr';
import { MdSportsTennis } from 'react-icons/md';
import { IoGolfOutline } from 'react-icons/io5';
import { RiBoxingFill } from 'react-icons/ri';
import { BsEmojiSmile } from 'react-icons/bs';
import { BiDotsHorizontalRounded, BiMap } from 'react-icons/bi';
import { TbSoccerField } from 'react-icons/tb';

import { H3 } from '../components/Text/Head';

const MainPage = () => {
  const dispatch = useDispatch();
  const [data, setData] = useState({ list: [] });
  const getCategoryAXIOS = useCallback(async () => {
    const response = await axiosInstance.get('/category?active=false');
    setData({ list: response.data });
    dispatch(getCategory({ list: response.data }));
  }, [setData]);

  useEffect(() => {
    getCategoryAXIOS();
  }, []);

  console.log(data.list.length);

  const iconSet = [
    <></>,
    <></>,
    <IoIosFitness size="23px" />,
    <GrYoga size="20px" />,
    <MdSportsTennis size="20px" />,
    <IoGolfOutline size="20px" />,
    <RiBoxingFill size="20px" />,
    <BsEmojiSmile size="20px" />,
    <TbSoccerField size="23px" />,
    <BiDotsHorizontalRounded size="23px" />,
  ];

  const activeCategory = [];
  for (let i = 2; i < iconSet.length; i++) {
    if (data.list.length !== 0) {
      activeCategory.push({
        idx: i,
        text: data.list[i].categoryTitle,
        code: data.list[i].categoryCode,
        icon: iconSet[i],
      });
    }
  }

  const split = [activeCategory.slice(0, 4), activeCategory.slice(4)];

  return (
    <>
      <MainPageGlobal>
        <Link to="/mypage">
          <MemberCard />
        </Link>
        <SearchbarWBtn
          Icon={
            <Link to="/map">
              <BiMap size="20" />
            </Link>
          }
        />
        <MainPageBtnsGroupStyle>
          <H3 maxWidth="790px" marginTop="40px">
            <StyledLink to="/facility">바로가기</StyledLink>
          </H3>
          {split.map((el, idx) => {
            return <MainQuickBtnGroup key={idx} category={el} />;
          })}
        </MainPageBtnsGroupStyle>

        <MainPageBtnsGroupStyle>
          <H3 maxWidth="790px" marginTop="20px" marginBottom="30px">
            <StyledLink to="/map">Miracle near me</StyledLink>
          </H3>
        </MainPageBtnsGroupStyle>

        <FacilityCard />
      </MainPageGlobal>
    </>
  );
};

export default MainPage;
