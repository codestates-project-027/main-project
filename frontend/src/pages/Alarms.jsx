//기능 구현 후 map 

import { AlarmCard } from '../components/Card/AlarmCard';
import { AlarmsPageGlobal } from '../styles/globalStyle/PageGlobalStyle';
import { H1 } from '../components/Text/Head';

const AlarmsPage = () => {
  
  return (
    <>
      <AlarmsPageGlobal>
        <H1>알람</H1>
        <div className="card--wrapper">
          <AlarmCard />
        </div>
      </AlarmsPageGlobal>
    </>
  );
};

export default AlarmsPage;
