import { BiBell } from 'react-icons/bi';
import { IoIosArrowDown } from 'react-icons/io';
import { TopNavbarGlobal } from '../../styles/globalStyle/BarGlobalStyle';

export const TopNavbarMain = () => {
  return (
    <>
      <TopNavbarGlobal>
        <div className="tab--wrapper">
          우리 동네 주소
          <IoIosArrowDown
            size="23"
            style={{ marginLeft: '10px', cursor: 'pointer' }}
          />
        </div>
        <div className="icon--wrapper">
          <BiBell size="23" style={{ marginLeft: '5px' }} />
        </div>
      </TopNavbarGlobal>
    </>
  );
};

export const TopNavbarMenu = () => {
  return (
    <>
      <TopNavbarGlobal>
        <div className="tab--wrapper">
          메뉴 이름만 쓰게
          <IoIosArrowDown
            size="23"
            style={{ marginLeft: '10px', cursor: 'pointer' }}
          />
        </div>
        <div className="icon--wrapper">
          <BiBell size="23" style={{ marginLeft: '5px' }} />
        </div>
      </TopNavbarGlobal>
    </>
  );
};

export const TopNavbarMenuSearch = () => {
  return (
    <>
      <TopNavbarGlobal>
        <div className="tab--wrapper">
          메뉴 이름만 쓰게 + search 아이콘
          <IoIosArrowDown
            size="23"
            style={{ marginLeft: '10px', cursor: 'pointer' }}
          />
        </div>
        <div className="icon--wrapper">
          <BiBell size="23" style={{ marginLeft: '5px' }} />
        </div>
      </TopNavbarGlobal>
    </>
  );
};
