import { FacilityForm } from '../components/Form/FacilityForms';
import { FacilityGlobal } from '../styles/globalStyle/PageGlobalStyle';
import Admin from '../pages/Admin';

export const RegisterFacilityPage = ({ fin, setFin }) => {
  return (
    <>
      <FacilityGlobal>
        <FacilityForm fin={fin} setFin={setFin} />
      </FacilityGlobal>
    </>
  );
};

export const EditFacilityPage = ({ fin, setFin }) => {
  return (
    <>
      <FacilityGlobal>
        <FacilityForm fin={fin} setFin={setFin} mode={'edit'} />
      </FacilityGlobal>
    </>
  );
};
