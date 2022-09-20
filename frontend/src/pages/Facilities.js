import TextLogo from '../assets/logo/minimi-text.png';
import Searchbar from '../components/Bar/Searchbar';

import { SearchbarGroupStyle } from '../styles/components/ComponentGroupStyle';
import { FacilitiesPageGlobal } from '../styles/globalStyle/PageGlobalStyle';
import { FacilityCardFlex } from '../components/Card/FacilityCard';
import { TagGroup } from '../components/Group/BtnAndTagGroup';

const FacilitiesPage = () => {
  const tags = ['배드민턴', '테니스', '탁구', '수영'];
  return (
    <>
      <FacilitiesPageGlobal>
        <SearchbarGroupStyle>
          <img style={{ width: '70px' }} alt="logo" src={TextLogo} />
          <Searchbar />
        </SearchbarGroupStyle>

        <div className="tags--wrapper">
          <div className="title" style={{ marginRight: '20px' }}>
            인기
          </div>
          <TagGroup tags={tags} />
        </div>
        <FacilityCardFlex />
        <FacilityCardFlex />
      </FacilitiesPageGlobal>
    </>
  );
};

export default FacilitiesPage;
