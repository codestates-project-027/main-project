import { EditMyFacilityGlobal } from '../styles/globalStyle/PageGlobalStyle';
import { FacilityDescCard } from '../components/Card/FacilityCard';
import { H1 } from '../components/Text/Head';

const EditMyFacilityPage = () => {
  return (
    <EditMyFacilityGlobal>
      <div className="facility--wrapper">
        <H1 marginBottom="30px">사용중인 시설 편집</H1>
        <FacilityDescCard text={'삭제'} backGround="black" color="red" />
      </div>
    </EditMyFacilityGlobal>
  );
};

export default EditMyFacilityPage;