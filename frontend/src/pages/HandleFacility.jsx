import { FacilityForm } from '../components/Form/FacilityForms';
import { FacilityGlobal } from '../styles/globalStyle/PageGlobalStyle';


export const RegisterFacilityPage = () => {

  return (
    <>
      <FacilityGlobal>
        <FacilityForm />
      </FacilityGlobal>
    </>
  );
};

export const EditFacilityPage = ({setFin}) => {

  return (
    <>
      <FacilityGlobal>
        <FacilityForm mode={'edit'}  />
      </FacilityGlobal>
    </>
  );
};
