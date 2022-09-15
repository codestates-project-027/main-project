import styled from 'styled-components';
import { BiBell } from 'react-icons/bi';
import { IoIosArrowDown } from 'react-icons/io';

const AppNavBar = () => {
  return (
    <>
      <AppNavBarStyle>
        <div className="tab--wrapper">
          우리 동네 주소
          <IoIosArrowDown size="23" style={{ marginLeft: '10px' }} />
        </div>
        <div className="icon--wrapper">
          {/* <BiMap size="23" /> */}
          <BiBell size="23" style={{ marginLeft: '5px' }} />
        </div>
      </AppNavBarStyle>
    </>
  );
};

export default AppNavBar;

const AppNavBarStyle = styled.div`
  display: flex;
  width: 90%;
  justify-content: space-between;
  align-items: center;
  .tab--wrapper {
    display: flex;
    justify-content: center;
    align-items: center;
  }
`;
