import { SearchbarGlobal } from '../../styles/globalStyle/BarGlobalStyle';
import { IconWrapper } from '../../styles/components/IconStyles';
import { BiSearch } from 'react-icons/bi';
import styled from 'styled-components';
import { SearchbarGroupStyle } from '../../styles/components/ComponentGroupStyle';
import TextLogo from '../../assets/logo/minimi-text.png';
import { SquareBtn } from '../../components/Button/Btns';
import { StyledLink } from '../../styles/components/TextStyles';

//auto
import { useState, useEffect } from 'react';
import { useSelector } from 'react-redux';
import { DropDown } from './Dropdownbar';

export const Searchbar = ({ placeholder }) => {
  const list = [];
  const codeList = [];
  const categoryState = useSelector((state) => state.category.list);

  for (let i = 1; i < categoryState.length; i++) {
    list.push(categoryState[i].categoryTitle);
    codeList.push({
      code: categoryState[i].categoryCode,
      title: categoryState[i].categoryTitle,
    });
  }

  const [hasText, setHasText] = useState(false);
  const [inputValue, setInputValue] = useState('');
  const [options, setOptions] = useState(list);
  const [selected, setSelected] = useState(-1);
  const [code, setCode] = useState('000');

  useEffect(() => {
    if (inputValue === '') {
      setHasText(false);
    }
  }, [inputValue]);

  const handleInputChange = (event) => {
    const { value } = event.target;
    if (value.includes('\\')) return;
    value ? setHasText(true) : setHasText(false);
    setInputValue(value);

    // 검색어 check
    const filterRegex = new RegExp(value, 'i');
    const resultOptions = list.filter((option) => option.match(filterRegex));
    setOptions(resultOptions);
  };

  const confirmCode = () => {
    codeList.map((el) =>
      el.title === options.toString() ? setCode(el.code) : null
    );
  };

  const handleDropDownClick = (clickedOption) => {
    setInputValue(clickedOption);
    const resultOptions = options.filter((option) => option === clickedOption);
    setOptions(resultOptions);
    setHasText(false);
    confirmCode(options);
  };

  const handleDeleteButtonClick = () => {
    setInputValue('');
  };

  const handleKeyUp = (event) => {
    if (hasText) {
      if (event.code === 'ArrowDown' && options.length - 1 > selected) {
        setSelected(selected + 1);
      }
      if (event.code === 'ArrowUp' && selected >= 0) {
        setSelected(selected - 1);
      }
      if (event.code === 'Enter' && selected >= 0) {
        handleDropDownClick(options[selected]);
        setSelected(-1);
        setHasText(false);
        confirmCode(options);
      }
    }
  };

  return (
    <>
      <Div>
        <SearchbarGlobal onKeyUp={handleKeyUp} hasText={hasText}>
          <Input
            type="text"
            className="searchbar"
            placeholder={placeholder}
            onChange={handleInputChange}
            value={inputValue}
          />
          {hasText ? (
            <div className="delete" onClick={handleDeleteButtonClick}>
              &times;
            </div>
          ) : null}

          <IconWrapper marginRight={'13px'}>
            {code === '000' ? (
              <BiSearch size="20" />
            ) : (
              <StyledLink to={`/category/${code}`}>
                <BiSearch size="20" />
              </StyledLink>
            )}
          </IconWrapper>
        </SearchbarGlobal>
        {hasText ? (
          <DropDown
            options={options}
            handleDropDownClick={handleDropDownClick}
            selected={selected}
          />
        ) : null}
      </Div>
    </>
  );
};

export const SearchbarWBtn = ({ Icon, noIcon }) => {
  return (
    <SearchbarGroupStyle margin="30px">
      <StyledLink to="/">
        <Img alt="logo" src={TextLogo} />
      </StyledLink>
      <Searchbar />
      {noIcon ? null : <SquareBtn>{Icon}</SquareBtn>}
    </SearchbarGroupStyle>
  );
};

const Input = styled.input`
  text-align: start;
`;

const Img = styled.img`
  width: 70px;
  margin-top: 7px;
`;

const Div = styled.div`
  display: block;
  flex-direction: column;
  width: 70%;
`;
