import { MemberCardFlex } from '../components/Card/MemberCard';
import AttendanceCard from '../components/Card/AttendanceCard';
import { MyPageGlobal } from '../styles/globalStyle/PageGlobalStyle';
import { FacilityDescCard } from '../components/Card/FacilityCard';
const MyPage = () => {
  return (
    <>
      <MyPageGlobal>
        <div className="title">마이 페이지</div>
        <div className="card--wrapper">
          <MemberCardFlex />
        </div>
        <div className="subtitle">사용중인 시설</div>
        <FacilityDescCard />

        <div className="subtitle rate">
          이달의 방문율
          <div className="rate">몇 프로</div>
        </div>

        <AttendanceCard />
      </MyPageGlobal>
    </>
  );
};

export default MyPage;
