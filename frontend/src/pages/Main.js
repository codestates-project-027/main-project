import styled from 'styled-components';

import { SearchbarWBtn } from '../components/Bar/Searchbar';

import { FacilityCard } from '../components/Card/FacilityCard';
import { MemberCard } from '../components/Card/MemberCard';
import { MainPageGlobal } from '../styles/globalStyle/PageGlobalStyle';
import { MainPageBtnsGroupStyle } from '../styles/components/ComponentGroupStyle';
import { MainQuickBtnGroup } from '../components/Group/BtnAndTagGroup';

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
  const activeCategory = [
    { idx: 1, text: '헬스/크로스핏', icon: <IoIosFitness size="23px" /> },
    { idx: 2, text: '요가/필라테스', icon: <GrYoga size="20px" /> },
    { idx: 3, text: '테니스', icon: <MdSportsTennis size="20px" /> },
    { idx: 4, text: '골프', icon: <IoGolfOutline size="20px" /> },
    { idx: 5, text: '킥복싱', icon: <RiBoxingFill size="20px" /> },
    { idx: 6, text: '운동클래스', icon: <BsEmojiSmile size="20px" /> },
    { idx: 7, text: '공공시설', icon: <TbSoccerField size="23px" /> },
    { idx: 8, text: '기타', icon: <BiDotsHorizontalRounded size="23px" /> },
  ];
  const split = [activeCategory.slice(0, 4), activeCategory.slice(4)];

  return (
    <>
      <MainPageGlobal>
        <MemberCard />
        <SearchbarWBtn Icon={<BiMap size="20" />} />
        <MainPageBtnsGroupStyle>
          <H3 maxWidth="790px" marginTop="40px">
            바로가기
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

const Img = styled.img`
  width: 70px;
`;
