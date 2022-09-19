import { AlarmCard } from '../components/Card/AlarmCard';
import { AlarmsPageGlobal } from '../styles/globalStyle/PageGlobalStyle';

const AlarmsPage = () => {
  return (
    <>
      <AlarmsPageGlobal>
        <div className="title">알람</div>
        <div className="card--wrapper">
          <AlarmCard />
          <AlarmCard />
        </div>
      </AlarmsPageGlobal>
    </>
  );
};

export default AlarmsPage;
