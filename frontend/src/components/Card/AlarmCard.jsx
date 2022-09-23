import { AlarmCardGlobal } from '../../styles/globalStyle/CardGlobalStyle';
import { AlarmCardStyle } from '../../styles/components/CardStyle';
import { FaBell } from 'react-icons/fa';

export const AlarmCard = () => {
  return (
    <>
      <AlarmCardGlobal>
        <AlarmCardStyle>
          <div className="icon--head--wrapper">
            <FaBell size="20" fill="var(--logo-yellow)" />
          </div>
          <div className="date">날짜</div>
        </AlarmCardStyle>
      </AlarmCardGlobal>
    </>
  );
};
