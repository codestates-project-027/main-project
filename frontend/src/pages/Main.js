import TextLogo from '../assets/logo/minimi-text.png';
import Searchbar from '../components/Bar/Searchbar';
import SquareBtn from '../components/Button/SquareBtn';
import QuickBtn from '../components/Button/QuickBtn';
import { FacilityCard } from '../components/Card/FacilityCard';
import { MemberCard } from '../components/Card/MemberCard';
import { MainPageGlobal } from '../styles/globalStyle/PageGlobalStyle';
import {
  SearchbarGroupStyle,
  MainPageBtnsGroupStyle,
} from '../styles/components/ComponentGroupStyle';
import { MainPageBtnIconStyle } from '../styles/components/IconStyles';
import { MainPageBtnTextStyle } from '../styles/components/TextStyles';
import { MainQuickBtn } from '../components/Button/QuickBtn';
import { MainQuickBtnGroup } from '../components/MainQuickBtnGroup';

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
  const activeCategory1 = activeCategory.slice(0, 4);
  const activeCategory2 = activeCategory.slice(4);

  return (
    <>
      <MainPageGlobal>
        <MemberCard />

        <SearchbarGroupStyle>
          <img style={{ width: '70px' }} alt="logo" src={TextLogo} />
          <Searchbar />
          <SquareBtn>
            <BiMap size="20" />
          </SquareBtn>
        </SearchbarGroupStyle>

        <MainPageBtnsGroupStyle>
          <H3 style={{ marginTop: '40px' }}>바로가기</H3>
          <MainQuickBtnGroup category={activeCategory1} />
          <MainQuickBtnGroup category={activeCategory2} />
        </MainPageBtnsGroupStyle>

        <MainPageBtnsGroupStyle>
          <H3 style={{ marginTop: '20px', marginBottom: '30px' }}>
            Miracle near me
          </H3>
        </MainPageBtnsGroupStyle>

        <FacilityCard />
      </MainPageGlobal>
    </>
  );
};

export default MainPage;
