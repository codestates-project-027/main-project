//기능 구현 후 map

import styled from 'styled-components';

import { SearchbarWBtn } from '../components/Bar/Searchbar';

import { FacilitiesPageGlobal } from '../styles/globalStyle/PageGlobalStyle';
import { FacilityCardFlex } from '../components/Card/FacilityCard';
import { TagGroup } from '../components/Group/BtnAndTagGroup';

const FacilitiesPage = () => {
  const tags = ['배드민턴', '테니스', '탁구', '수영'];
  return (
    <>
      <FacilitiesPageGlobal>
        <SearchbarWBtn noIcon="noIcon" />

        <div className="tags--wrapper">
          <Div className="title">인기</Div>
          <TagGroup tags={tags} />
        </div>
        <FacilityCardFlex />
        <FacilityCardFlex />
      </FacilitiesPageGlobal>
    </>
  );
};

export default FacilitiesPage;


const Div = styled.div`
  margin-right: 20px;
`;