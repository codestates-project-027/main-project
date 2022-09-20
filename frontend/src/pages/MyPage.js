import { MemberCardFlex } from '../components/Card/MemberCard';
import AttendanceCard from '../components/Card/AttendanceCard';
import { MyPageGlobal } from '../styles/globalStyle/PageGlobalStyle';
import { FacilityDescCard } from '../components/Card/FacilityCard';
import { H1, H3 } from '../components/Text/Head';

const MyPage = () => {
  return (
    <>
      <MyPageGlobal>
        <H1>마이 페이지</H1>
        <div className="card--wrapper">
          <MemberCardFlex />
        </div>
        <H3 style={{ marginBottom: '30px' }}>사용중인 시설</H3>
        <div className="my--wrapper" style={{ marginBottom: '20px' }}>
          <FacilityDescCard />
        </div>

        <H3
          style={{
            display: 'flex',
            marginBottom: '30px',
            justifyContent: 'space-between',
          }}
        >
          이달의 방문율
          <div
            style={{
              marginRight: '20px',
            }}
          >
            몇 프로
          </div>
        </H3>

        <AttendanceCard />
      </MyPageGlobal>
    </>
  );
};

export default MyPage;
