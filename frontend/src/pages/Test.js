import DistanceCalc from '../components/Calculator/DistanceCalc';

const TestPage = () => {
  return (
    <DistanceCalc
      currentLocation={{ latitude: 33.450701, longitude: 126.570667 }}
      facilityLocation={'33.450936, 126.569477'} //생태연못
      // facilityLocation={'33.458692, 126.618563'} //족은노루손이
  

      //kakao스페이스 닷원~생태연못 거리 137m  / 직선거리 0.11km
    />
  );
};

export default TestPage;
