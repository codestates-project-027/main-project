import { MainPageBIGroupStyle } from '../../styles/components/ComponentGroupStyle';
import { FacilityPageDescGroupStyle } from '../../styles/components/ComponentGroupStyle';

import { MainQuickBtn } from '../Button/QuickBtn';
import { H4 } from '../../components/Text/Head';

import { TagStyle } from '../../styles/components/TagStyle';
import { CgWebsite } from 'react-icons/cg';
import { BiMap, BiBell } from 'react-icons/bi';
import { IoCallOutline } from 'react-icons/io5';

export const MainQuickBtnGroup = ({ category }) => {
  return (
    <>
      <MainPageBIGroupStyle>
        {category.map((el) => {
          return (
            <>
              <MainQuickBtn
                key={el.idx}
                textProp={el.text}
                iconProp={el.icon}
              />
            </>
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
      {tags.map((el) => {
        return <TagStyle>{el}</TagStyle>;
      })}
    </>
  );
};
