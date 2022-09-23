import { MainPageBIGroupStyle } from '../../styles/components/ComponentGroupStyle';
import { FacilityPageDescGroupStyle } from '../../styles/components/ComponentGroupStyle';

import { MainQuickBtn } from '../Button/Btns';
import { H4 } from '../../components/Text/Head';

import { TagStyle, TagStyleInDesc } from '../../styles/components/TagStyle';
import styled from 'styled-components';

export const MainQuickBtnGroup = ({ category }) => {
  return (
    <>
      <MainPageBIGroupStyle>
        {category.map((el) => {
          return (
            <MainQuickBtn key={el.idx} textProp={el.text} iconProp={el.icon} />
          );
        })}
      </MainPageBIGroupStyle>
    </>
  );
};

export const FacilityDescGroup = ({ facility }) => {
  return (
    <FacilityPageDescGroupStyle>
      {facility.map((el) => {
        return (
          <H4 key={el.idx}>
            {el.icon} {el.value}
          </H4>
        );
      })}
    </FacilityPageDescGroupStyle>
  );
};

export const TagGroup = ({
  tags,
  tagsList,
  setTagsList,
  close,
  backGround,
  margin,
}) => {
  const handleRemove = (idxToRemove) => {
    setTagsList(tagsList.filter((_, index) => index !== idxToRemove));
  };

  return (
    <>
      {tags.map((el, idx) => {
        return (
          <TagStyle backGround={backGround} margin={margin} key={idx}>
            {el}
            {close ? <X onClick={() => handleRemove(idx)}>x</X> : null}
          </TagStyle>
        );
      })}
    </>
  );
};

const X = styled.div`
  line-height: 17px;
  background: white;
  width: 20px;
  border-radius: 100%;
  margin-left: 5px;
  cursor: pointer;
`;
