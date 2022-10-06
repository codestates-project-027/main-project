import styled from 'styled-components';
import { useState, useEffect } from 'react';
import axiosInstance from '../api/Interceptor';
import { AiFillSetting } from 'react-icons/ai';
import { MyPageGlobal } from '../styles/globalStyle/PageGlobalStyle';
import { IconWrapper } from '../styles/components/IconStyles';
import { MemberCard } from '../components/Card/MemberCard';
import AttendanceCard from '../components/Card/AttendanceCard';
import { FacilityDescCard } from '../components/Card/FacilityCard';
import { H1, H3 } from '../components/Text/Head';

const MyPage = ({ fin, setFin }) => {
  const [data, setData] = useState({ username: '', facilityList: [] });
  const [days, setDays] = useState({ username: '', checkDailyList: [] });
  const [show, setShow] = useState(false);

  const getMyFacility = async () => {
    const response = await axiosInstance.get('/myfacility/minimiUser');
    setData(response.data);
  };

  const getDailyChecks = async () => {
    const response = await axiosInstance.get('/dailycheck/minimiUser');
    setDays(response.data.checkDailyList);
  };

  const attended =
    days.username !== '' ? days.filter((el) => el === 'true').length : null;
  const rate = `${(attended / days.length) * 100} %`;

  useEffect(() => {
    getMyFacility();
    getDailyChecks();
  }, [fin]);

  return (
    <>
      <MyPageGlobal>
        <H1>마이 페이지</H1>
        <div className="card--wrapper">
          <MemberCard Flex={'Flex'} setFin={setFin} fin={fin} />
        </div>
        <div className="facility--wrapper">
          <H3 marginBottom="30px">사용중인 시설</H3>
          <IconWrapper
            marginRight="10px"
            onClick={() => {
              setShow(!show);
            }}
          >
            <AiFillSetting />
          </IconWrapper>
        </div>

        <Div className="my--wrapper" marginBottom="20px">
          {data.facilityList !== undefined
            ? data.facilityList.map((el) => {
                if (el.location !== null) {
                  return (
                    <FacilityDescCard
                      fin={fin}
                      setFin={setFin}
                      key={el.facilityId}
                      text={'출석'}
                      el={el}
                      show={show}
                    />
                  );
                }
              })
            : ''}
        </Div>

        <H3 display="flex" marginBottom="30px" justifyContent="space-between">
          이달의 방문율
          <Div marginRight="20px">{days.username !== '' && rate}</Div>
        </H3>

        {days.username !== '' && <AttendanceCard days={days} />}
      </MyPageGlobal>
    </>
  );
};

export default MyPage;

const Div = styled.div`
  margin-bottom: ${(props) => props.marginBottom};
  margin-right: ${(props) => props.marginRight};
`;
