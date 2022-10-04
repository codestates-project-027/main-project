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

  const [data, setData] = useState({ username: '', facilityList: [] });
  const getMyFacility = async () => {
    const response = await axiosInstance.get('/myfacility/minimiUser');
    setData(response.data);
  };

  const [show, setShow] = useState(false);

  useEffect(() => {
    getMyFacility();
  }, []);

  return (
    <>
      <MyPageGlobal>
        <H1>마이 페이지</H1>
        <div className="card--wrapper">
          <MemberCard Flex={'Flex'} />
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
          {data.username !== ''
            ? data.facilityList.map((el) => {
                return (
                  <FacilityDescCard
                    key={el.facilityId}
                    text={'출석'}
                    el={el}
                    show={show}

                  />
                );
              })
            : null}
          {console.log(data)}
        </Div>

        <H3 display="flex" marginBottom="30px" justifyContent="space-between">
          이달의 방문율
          <Div marginRight="20px">몇 프로</Div>
        </H3>
        {/*출석 조회 로직*/}
        <AttendanceCard days={days} />
      </MyPageGlobal>
    </>
  );
};

export default MyPage;

const Div = styled.div`
  margin-bottom: ${(props) => props.marginBottom};
  margin-right: ${(props) => props.marginRight};
`;
