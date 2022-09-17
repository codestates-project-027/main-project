import TextLogo from '../assets/logo/minimi-text.png';
import Searchbar from '../components/Bar/Searchbar';
import SquareBtn from '../components/Button/SquareBtn';
import QuickBtn from '../components/Button/QuickBtn';
import FacilityCard from '../components/Card/FacilityCard';
import MemberCard from '../components/Card/MemberCard';
import { MainPageGlobal } from '../styles/globalStyle/PageGlobalStyle';
import {
  SearchbarGroupStyle,
  MainPageBtnsGroupStyle,
} from '../styles/components/ComponentGroupStyle';
import { MainPageBtnIconStyle } from '../styles/components/IconStyles';
import { MainPageBtnTextStyle } from '../styles/components/TextStyles';
import { IoIosFitness } from 'react-icons/io';
import { GrYoga } from 'react-icons/gr';
import { MdSportsTennis } from 'react-icons/md';
import { IoGolfOutline } from 'react-icons/io5';
import { RiBoxingFill } from 'react-icons/ri';
import { BsEmojiSmile } from 'react-icons/bs';
import { BiDotsHorizontalRounded, BiMap } from 'react-icons/bi';
import { TbSoccerField } from 'react-icons/tb';

const MainPage = () => {
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
          <div className="menu--title">바로가기</div>
          <div className="menu--icons--wrapper">
            <QuickBtn>
              <MainPageBtnIconStyle>
                <IoIosFitness size="23px" />
              </MainPageBtnIconStyle>
              <MainPageBtnTextStyle>
                헬스 <br />
                크로스핏
              </MainPageBtnTextStyle>
            </QuickBtn>

            <QuickBtn>
              <MainPageBtnIconStyle>
                <GrYoga size="20px" />
              </MainPageBtnIconStyle>
              <MainPageBtnTextStyle>
                요가 <br />
                필라테스
              </MainPageBtnTextStyle>
            </QuickBtn>

            <QuickBtn>
              <MainPageBtnIconStyle>
                <MdSportsTennis size="20px" />
              </MainPageBtnIconStyle>
              <MainPageBtnTextStyle>테니스</MainPageBtnTextStyle>
            </QuickBtn>

            <QuickBtn>
              <MainPageBtnIconStyle>
                <IoGolfOutline size="20px" />
              </MainPageBtnIconStyle>
              <MainPageBtnTextStyle>골프</MainPageBtnTextStyle>
            </QuickBtn>
          </div>

          <div className="menu--icons--wrapper">
            <QuickBtn>
              <MainPageBtnIconStyle>
                <RiBoxingFill size="20px" />
              </MainPageBtnIconStyle>
              <MainPageBtnTextStyle>킥복싱</MainPageBtnTextStyle>
            </QuickBtn>

            <QuickBtn>
              <MainPageBtnIconStyle>
                <BsEmojiSmile size="20px" />
              </MainPageBtnIconStyle>
              <MainPageBtnTextStyle>
                운동
                <br />
                클래스
              </MainPageBtnTextStyle>
            </QuickBtn>

            <QuickBtn>
              <MainPageBtnIconStyle>
                <TbSoccerField size="23px" />
              </MainPageBtnIconStyle>
              <MainPageBtnTextStyle>공공시설</MainPageBtnTextStyle>
            </QuickBtn>

            <QuickBtn>
              <MainPageBtnIconStyle>
                <BiDotsHorizontalRounded size="23px" />
              </MainPageBtnIconStyle>
              <MainPageBtnTextStyle>기타</MainPageBtnTextStyle>
            </QuickBtn>
          </div>
        </MainPageBtnsGroupStyle>

        <MainPageBtnsGroupStyle>
          <div className="menu--title">Miracle near me</div>
        </MainPageBtnsGroupStyle>

        <FacilityCard />
      </MainPageGlobal>
    </>
  );
};

export default MainPage;
