import { MainPageBIGroupStyle } from '../../styles/components/ComponentGroupStyle';
import { MainQuickBtn } from '../Button/QuickBtn';
import { TagStyle } from '../../styles/components/TagStyle';

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

export const TagGroup = ({ tags }) => {
  return (
    <>
      {tags.map((el) => {
        return <TagStyle>{el}</TagStyle>;
      })}
    </>
  );
};
