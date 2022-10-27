import styled from 'styled-components';
// import { useState } from 'react';

import { SearchbarWBtn } from '../components/Bar/Searchbar';

import { FacilitiesPageGlobal } from '../styles/globalStyle/PageGlobalStyle';
import { FacilityCard } from '../components/Card/FacilityCard';
import { TagGroup } from '../components/Group/BtnAndTagGroup';

const FacilitiesPage = ({ mode, fin, setFin }) => {
  const tags = ['헬스', '수영', '킥복싱', '탁구']; //popular

  return (
    <>
      <FacilitiesPageGlobal>
        <SearchbarWBtn noIcon="noIcon" width="100%" />

        <div className="tags--wrapper">
          <Div className="title">인기</Div>
          <TagGroup tags={tags} fin={fin} setFin={setFin} />
        </div>

        <FacilityCard Detail={'Detail'} mode={mode} fin={fin} setFin={setFin} margin='0 0 0 10px' />
      </FacilitiesPageGlobal>
    </>
  );
};

export default FacilitiesPage;

const Div = styled.div`
  margin-right: 20px;
`;
