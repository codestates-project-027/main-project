import { SearchbarGlobal } from '../../styles/globalStyle/BarGlobalStyle';
import { IconStyle } from '../../styles/components/IconStyles';
import { BiSearch } from 'react-icons/bi';

const Searchbar = () => {
  return (
    <>
      <SearchbarGlobal>
        <input
          type="text"
          className="searchbar"
          placeholder="어떤 운동을 찾으세요?"
          style={{ textAlign: 'start' }}
        />
        <BiSearch style={IconStyle} size="20" />
      </SearchbarGlobal>
    </>
  );
};

export default Searchbar;
