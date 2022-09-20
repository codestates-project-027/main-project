import { MainPageBIGroupStyle } from '../styles/components/ComponentGroupStyle';
import { MainQuickBtn } from './Button/QuickBtn';

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
