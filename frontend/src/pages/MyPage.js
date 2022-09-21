import { MemberCardFlex } from '../components/Card/MemberCard';
import AttendanceCard from '../components/Card/AttendanceCard';
import { MyPageGlobal } from '../styles/globalStyle/PageGlobalStyle';
import { FacilityDescCard } from '../components/Card/FacilityCard';
import { H1, H3 } from '../components/Text/Head';
import { AiFillSetting } from 'react-icons/ai';

const MyPage = () => {
  const days = [
    true,
    false,
    true,
    true,
    false,
    true,
    false,
    true,
    true,
    true,
    true,
    true,
    true,
    true,
    true,
    true,
    false,
    true,
    true,
    true,
    false,
    true,
    false,
    false,
    false,
  ];

  return (
    <>
      <MyPageGlobal>
        <H1>마이 페이지</H1>
        <div className="card--wrapper">
          <MemberCardFlex />
        </div>
        <div className="facility--wrapper">
          <H3 style={{ marginBottom: '30px' }}>사용중인 시설</H3>
          <AiFillSetting style={{ marginRight: '10px' }} />
        </div>

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

        <AttendanceCard days={days} />
      </MyPageGlobal>
    </>
  );
};

export default MyPage;
