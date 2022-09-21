import { EditMyFacilityGlobal } from '../styles/globalStyle/PageGlobalStyle';
import { FacilityDescCardEdit } from '../components/Card/FacilityCard';
import { H1 } from '../components/Text/Head';

const EditMyFacilityPage = () => {
  return (
    <EditMyFacilityGlobal>
      <div className="facility--wrapper">
        <H1 style={{ marginBottom: '30px' }}>사용중인 시설 편집</H1>
        <FacilityDescCardEdit />
      </div>
    </EditMyFacilityGlobal>
  );
};

export default EditMyFacilityPage;
