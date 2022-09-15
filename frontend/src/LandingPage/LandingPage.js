import Logo from './Logo';
import Searchbar from './Searchbar';
import styled from 'styled-components';
import QuickBtn from './QuickBtn';
import { IoIosFitness } from 'react-icons/io';
import { GrYoga } from 'react-icons/gr';
import { MdSportsTennis } from 'react-icons/md';
import { IoGolfOutline } from 'react-icons/io5';
import { RiBoxingFill } from 'react-icons/ri';
import { BsEmojiSmile } from 'react-icons/bs';
import { BiDotsHorizontalRounded } from 'react-icons/bi';
import { TbSoccerField } from 'react-icons/tb';
import FacilityCard from './FacilityCard';
import MemberCard from './MemberCard';

const LandingPage = () => {
  return (
    <>
      <MemberCard />
      <LogoAndSearchStyle>
        <Logo />
        <Searchbar />
      </LogoAndSearchStyle>
      <MenuStyle>
        <div className="menu--title">바로가기</div>
        <div className="menu--icons--wrapper">
          <QuickBtn>
            <IconStyle>
              <IoIosFitness size="23px" />
            </IconStyle>
            <TextStyle>
              헬스 <br />
              크로스핏
            </TextStyle>
          </QuickBtn>

          <QuickBtn>
            <IconStyle>
              <GrYoga size="20px" />
            </IconStyle>
            <TextStyle>
              요가 <br />
              필라테스
            </TextStyle>
          </QuickBtn>

          <QuickBtn>
            <IconStyle>
              <MdSportsTennis size="20px" />
            </IconStyle>
            <TextStyle>테니스</TextStyle>
          </QuickBtn>

          <QuickBtn>
            <IconStyle>
              <IoGolfOutline size="20px" />
            </IconStyle>
            <TextStyle>골프</TextStyle>
          </QuickBtn>
        </div>
        <div className="menu--icons--wrapper">
          <QuickBtn>
            <IconStyle>
              <RiBoxingFill size="20px" />
            </IconStyle>
            <TextStyle>킥복싱</TextStyle>
          </QuickBtn>

          <QuickBtn>
            <IconStyle>
              <BsEmojiSmile size="20px" />
            </IconStyle>
            <TextStyle>
              운동
              <br />
              클래스
            </TextStyle>
          </QuickBtn>

          <QuickBtn>
            <IconStyle>
              <TbSoccerField size="23px" />
            </IconStyle>
            <TextStyle>공공시설</TextStyle>
          </QuickBtn>

          <QuickBtn>
            <IconStyle>
              <BiDotsHorizontalRounded size="23px" />
            </IconStyle>
            <TextStyle>기타</TextStyle>
          </QuickBtn>
        </div>
      </MenuStyle>
      <MenuStyle>
        <div className="menu--title">Miracle near me</div>
      </MenuStyle>

      <FacilityCard />
    </>
  );
};

export default LandingPage;

export const LogoAndSearchStyle = styled.div`
  display: flex;
  justify-content: center;
  align-items: center;
  width: 60%;
  @media screen and (max-width: 790px) {
    width: 80%;
  }
`;

const MenuStyle = styled.div`
  display: flex;
  flex-direction: column;
  margin-left: 60px;
  width: 42%;
  /* background: black; */

  @media screen and (max-width: 790px) {
    width: 50%;
  }
  .menu--title {
    font-size: 15px;
    text-align: left;
    margin-top: 30px;
    margin-bottom: 15px;
    padding: 5px;
    @media screen and (max-width: 790px) {
      display: none;
    }
  }
  .menu--icons--wrapper {
    display: flex;
    align-items: center;
    justify-content: space-evenly;
    flex-wrap: wrap;

    @media screen and (min-width: 1098px) {
      height: 150px;
    }
    @media screen and (max-width: 1097px) {
      height: 100px;
    }
  }

  @media screen and (max-width: 1097px) {
    margin-top: 5px;
    margin-left: 35px;
  }

  @media screen and (max-width: 875px) {
    margin-top: 5px;
    margin-left: 25px;
  }

  @media screen and (max-width: 790px) {
    margin-top: 5px;
    margin-left: -15px;
  }
`;

const IconStyle = styled.div`
  @media screen and (max-width: 3000px) {
    display: none;
  }

  @media screen and (max-width: 1500px) {
    display: flex;
  }
`;

const TextStyle = styled.div`
  @media screen and (max-width: 3000px) {
    display: flex;
  }

  @media screen and (max-width: 1500px) {
    display: none;
  }
`;

// const MiracleNearMeStyle = styled.div`
//   display: flex;
//   flex-direction: column;
// `;
