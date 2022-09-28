import styled from 'styled-components';
import { Link } from 'react-router-dom';
import { useSelector } from 'react-redux';
import { SearchbarWBtn } from '../components/Bar/Searchbar';

import { FacilityCard } from '../components/Card/FacilityCard';
import { MemberCard } from '../components/Card/MemberCard';
import { MainPageGlobal } from '../styles/globalStyle/PageGlobalStyle';
import { MainPageBtnsGroupStyle } from '../styles/components/ComponentGroupStyle';
import { MainQuickBtnGroup } from '../components/Group/BtnAndTagGroup';
import { StyledLink } from '../styles/components/TextStyles';

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
  const categoryState = useSelector((state) => state.category);
  const activeCategory = [
    {
      idx: 1,
      text: categoryState.list[0].categoryTitle,
      icon: <IoIosFitness size="23px" />,
    },
    {
      idx: 2,
      text: categoryState.list[1].categoryTitle,
      icon: <GrYoga size="20px" />,
    },
    {
      idx: 3,
      text: categoryState.list[2].categoryTitle,
      icon: <MdSportsTennis size="20px" />,
    },
    {
      idx: 4,
      text: categoryState.list[3].categoryTitle,
      icon: <IoGolfOutline size="20px" />,
    },
    {
      idx: 5,
      text: categoryState.list[4].categoryTitle,
      icon: <RiBoxingFill size="20px" />,
    },
    {
      idx: 6,
      text: categoryState.list[5].categoryTitle,
      icon: <BsEmojiSmile size="20px" />,
    },
    {
      idx: 7,
      text: categoryState.list[6].categoryTitle,
      icon: <TbSoccerField size="23px" />,
    },
    {
      idx: 8,
      text: categoryState.list[7].categoryTitle,
      icon: <BiDotsHorizontalRounded size="23px" />,
    },
  ];
  const split = [activeCategory.slice(0, 4), activeCategory.slice(4)];

  return (
    <>
      <MainPageGlobal>
        <MemberCard />
        <SearchbarWBtn
          Icon={
            <Link to="/map">
              <BiMap size="20" />
            </Link>
          }
        />
        <MainPageBtnsGroupStyle>
          <H3 maxWidth="790px" marginTop="40px">
            <StyledLink to="/facilities">바로가기</StyledLink>
          </H3>
          {split.map((el, idx) => {
            return <MainQuickBtnGroup key={idx} category={el} />;
          })}
        </MainPageBtnsGroupStyle>

        <MainPageBtnsGroupStyle>
          <H3 maxWidth="790px" marginTop="20px" marginBottom="30px">
            Miracle near me
          </H3>
        </MainPageBtnsGroupStyle>

        <FacilityCard />
      </MainPageGlobal>
    </>
  );
};

export default MainPage;
