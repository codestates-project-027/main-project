import styled from 'styled-components';

import { SearchbarWBtn } from '../components/Bar/Searchbar';

import { FacilitiesPageGlobal } from '../styles/globalStyle/PageGlobalStyle';
import { FacilityCard } from '../components/Card/FacilityCard';
import { TagGroup } from '../components/Group/BtnAndTagGroup';

const FacilitiesPage = ({mode}) => {
  const tags = ['헬스', '테니스', '킥복싱'];
  return (
    <>
      <FacilitiesPageGlobal>
        <SearchbarWBtn noIcon="noIcon" />

        <div className="tags--wrapper">
          <Div className="title">인기</Div>
          <TagGroup tags={tags} />
        </div>
        <FacilityCard Detail={'Detail'} mode={mode} />
      </FacilitiesPageGlobal>
    </>
  );
};

export default FacilitiesPage;

const Div = styled.div`
  margin-right: 20px;
`;
