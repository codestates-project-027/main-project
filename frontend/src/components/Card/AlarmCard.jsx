import { AlarmCardGlobal } from '../../styles/globalStyle/CardGlobalStyle';
import { AlarmCardStyle } from '../../styles/components/CardStyle';
export const AlarmCard = () => {
  return (
    <>
      <AlarmCardGlobal>
        <AlarmCardStyle>
          <div className="icon--head--wrapper">아이콘 내용</div>
          <div className="date">날짜</div>
        </AlarmCardStyle>
      </AlarmCardGlobal>
    </>
  );
};
