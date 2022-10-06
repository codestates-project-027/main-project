import {
  MCardGlobal,
  MCardFlexGlobal,
} from '../../styles/globalStyle/CardGlobalStyle';
import { useState, useEffect } from 'react';
import axiosInstance from '../../api/Interceptor';
import CharLogo from '../../assets/logo/minimi-char.png';

export const MemberCard = ({ Flex, fin, setFin }) => {
  const [days, setDays] = useState({
    username: '',
    checkDailyList: [],
    score: 0,
  });
  const getDailyChecks = async () => {
    const response = await axiosInstance.get('/dailycheck/minimiUser');
    const response2 = await axiosInstance.get('/miracleScore/minimiUser');
    setDays({
      username: response.data.username,
      checkDailyList: response.data.checkDailyList,
      score: response2.data.score,
    });
  };

  useEffect(() => {
    getDailyChecks();
  }, [fin]);

  const attended =
    days.username !== ''
      ? days.checkDailyList.filter((el) => el === 'true').length
      : null;
  const rate = `${(attended / days.checkDailyList.length) * 100} %`;

  return Flex ? (
    <>
      <MCardFlexGlobal>
        <div className="wrapper">
          <div className="img--wrapper">
            <img src={CharLogo} width="90px" alt="review" />
          </div>
          <div className="content--wrapper">
            <div>{days.username}</div>
            <div>이번달 방문율 : {rate}</div>
            <div>미니미 Score : {days.score}</div>
          </div>
        </div>
      </MCardFlexGlobal>
    </>
  ) : (
    <>
      <MCardGlobal>
        <div className="wrapper">
          <div className="img--wrapper">
            <img src={CharLogo} width="90px" alt="review" />
          </div>
          <div className="content--wrapper">
            <div>{days.username}</div>
            <div>이번달 방문율 : {rate}</div>
            <div>미니미 Score : {days.score}</div>
          </div>
        </div>
      </MCardGlobal>
    </>
  );
};
