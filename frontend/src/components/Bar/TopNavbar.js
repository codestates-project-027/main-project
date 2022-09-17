import { BiBell } from 'react-icons/bi';
import { IoIosArrowDown } from 'react-icons/io';
import { TopNavbarGlobal } from '../../styles/globalStyle/NavbarGlobalStyle';

const TopNavbar = () => {
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

export default TopNavbar;
