import { MainPageBIGroupStyle } from '../../styles/components/ComponentGroupStyle';
import { FacilityPageDescGroupStyle } from '../../styles/components/ComponentGroupStyle';

import { MainQuickBtn } from '../Button/QuickBtn';
import { H4 } from '../../components/Text/Head';

import { TagStyle, TagStyleInDesc } from '../../styles/components/TagStyle';

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

export const TagGroup = ({ tags }) => {
  return (
    <>
      {tags.map((el, idx) => {
        return <TagStyle key={idx}>{el}</TagStyle>;
      })}
    </>
  );
};

export const TagGroupX = ({ tags, tagsList, setTagsList }) => {
  const handleRemove = (idxToRemove) => {
    setTagsList(tagsList.filter((_, index) => index !== idxToRemove));
  };

  return (
    <>
      {tags.map((el, idx) => {
        return (
          <TagStyle key={idx}>
            {el}
            <div
              onClick={() => handleRemove(idx)}
              style={{
                lineHeight: '17px',
                background: 'white',
                width: '20px',
                borderRadius: '100%',
                marginLeft: '5px',
                cursor: 'pointer',
              }}
            >
              x
            </div>
          </TagStyle>
        );
      })}
    </>
  );
};

export const TagGroupDesc = ({ tags }) => {
  return (
    <>
      {tags.map((el) => {
        return (
          <TagStyleInDesc key={el} style={{ marginRight: '10px' }}>
            {el}
          </TagStyleInDesc>
        );
      })}
    </>
  );
};
