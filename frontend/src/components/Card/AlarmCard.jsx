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
            <div className="msg">서비스 시작</div>
          </div>

          <div className="date">22.10.12</div>
        </AlarmCardStyle>
      </AlarmCardGlobal>
    </>
  );
};
