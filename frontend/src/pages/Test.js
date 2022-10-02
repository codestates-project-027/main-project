import { SearchbarGlobal } from '../styles/globalStyle/BarGlobalStyle';
import { IconWrapper } from '../styles/components/IconStyles';
import { BiSearch } from 'react-icons/bi';
import styled from 'styled-components';

//auto
import { useState, useEffect } from 'react';
import { useSelector } from 'react-redux';

const TestPage = () => {
  const list = [];
  const categoryState = useSelector((state) => state.category.list);

  for (let i = 1; i < categoryState.length; i++) {
    list.push(categoryState[i].categoryTitle);
  }

  const [hasText, setHasText] = useState(false);
  const [inputValue, setInputValue] = useState('');
  const [options, setOptions] = useState(list);
  const [selected, setSelected] = useState(-1);

  useEffect(() => {
    if (inputValue === '') {
      setHasText(false);
    }
  }, [inputValue]);

  const handleInputChange = (event) => {
    const { value } = event.target;
    if (value.includes('\\')) return;

    // input에 텍스트가 있는지 없는지 확인하는 코드
    value ? setHasText(true) : setHasText(false);

    // updateText
    setInputValue(value);

    // dropdown을 위한 기능
    const filterRegex = new RegExp(value, 'i');
    const resultOptions = list.filter((option) => option.match(filterRegex));
    setOptions(resultOptions);
    console.log(resultOptions);
  };

  const handleDropDownClick = (clickedOption) => {
    setInputValue(clickedOption);
    const resultOptions = options.filter((option) => option === clickedOption);
    setOptions(resultOptions);
  };

  const handleDeleteButtonClick = () => {
    setInputValue('');
  };

  const handleKeyUp = (event) => {
    // https://developer.mozilla.org/en-US/docs/Web/API/KeyboardEvent/getModifierState#example
    // eslint-disable-next-line
    if (
      event.getModifierState('Fn') ||
      event.getModifierState('Hyper') ||
      event.getModifierState('OS') ||
      event.getModifierState('Super') ||
      event.getModifierState('Win')
    )
      return;
    if (
      event.getModifierState('Control') +
        event.getModifierState('Alt') +
        event.getModifierState('Meta') >
      1
    )
      return;
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
      }
    }
  };

  console.log(inputValue);

  return (
    <>
      <Div> //추가
        <SearchbarGlobal onKeyUp={handleKeyUp} hasText={hasText}>
          <Input
            type="text"
            className="searchbar"
            placeholder="무엇 검색"
            onChange={handleInputChange}
            value={inputValue}
          />
          {hasText ? (
            <div className="delete-button" onClick={handleDeleteButtonClick}>
              &times;
            </div>
          ) : null}

          <IconWrapper marginRight={'13px'}>
            <BiSearch size="20" />
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

export default TestPage;

const Div = styled.div`
  display: flex;
  flex-direction: column;
`;
export const DropDown = ({ options, handleDropDownClick, selected }) => {
  return (
    <DropDownContainer>
      {options.map((option, idx) => (
        <li
          key={idx}
          onClick={() => handleDropDownClick(option)}
          className={selected === idx ? 'selected' : ''}
        >
          {option}
        </li>
      ))}
    </DropDownContainer>
  );
};

const Input = styled.input`
  text-align: start;
`;

export const DropDownContainer = styled.ul`
  background-color: #ffffff;
  display: flex;
  margin-left: auto;
  margin-right: auto;
  list-style-type: none;
  margin-block-start: 0;
  margin-block-end: 0;
  margin-inline-start: 0px;
  margin-inline-end: 0px;
  padding-inline-start: 0px;
  margin-top: -1px;
  padding: 0.5rem 0;
  border: 1px solid rgb(223, 225, 229);
  border-radius: 0 0 1rem 1rem;
  box-shadow: 3px 3px 3px lightgray;
  z-index: 3;
  width: 100%;
  cursor: pointer;

  > li {
    padding: 0 1rem;
    text-align: left;
    width: 100%;

    &:hover {
      background-color: #eee;
    }

    &.selected {
      background-color: #ebe5f9;
    }
  }
`;
// //infinite scroll
// import axios from 'axios';
// import {useState, useRef, useEffect} from 'react'

// const Test = () => {
//     // state
//     const [infoArray, setInfoArray] = useState([]);

//     // ref
//     const observerRef = useRef(null);
//     const boxRef = useRef(null);

//     // useEffect
//     useEffect(() => {
//         getInfo();
//     }, [])

//     useEffect(() => {
//         observerRef.current = new IntersectionObserver(intersectionObserver); // IntersectionObserver
//         boxRef.current && observerRef.current.observe(boxRef.current);
//     }, [infoArray])

//     // function
//     const getInfo = async () => {
//         const res = await axios.get('http://localhost:8080/rest'); // 서버에서 데이터 가져오기
//         setInfoArray((curInfoArray) => [...curInfoArray, ...res.data]); // state에 추가

//         console.log('info data add...');
//     }

//     // IntersectionObserver 설정
//     const intersectionObserver = (entries, io) => {
//         entries.forEach((entry) => {
//             if(entry.isIntersecting) { // 관찰하고 있는 entry가 화면에 보여지는 경우
//                 io.unobserve(entry.target); // entry 관찰 해제
//                 getInfo(); // 데이터 가져오기
//             }
//         })
//     }

//     // style
//     const Wrapper = {
//         width: '800px',

//         margin: '0 auto'
//     }

//     const Box = {
//         border: '1px solid olive',
//         borderRadius: '8px',

//         boxShadow: '1px 1px 2px olive',

//         margin: '18px 0'
//     }

//     const BoxTable = {
//         borderSpacing: '15px'
//     }

//     const Title = {
//         fontWeight: 700
//     }

//     return (
//         <div style={Wrapper}>
//                 {infoArray.map((info, index) => {
//                     if(infoArray.length-5 === index) {
//                         // 관찰되는 요소가 있는 html, 아래에서 5번째에 해당하는 박스를 관찰
//                         return (
//                             <div style={Box} ref={boxRef} key={index}>
//                                 <table style={BoxTable}>
//                                     <tbody>
//                                         <tr>
//                                             <td style={Title}>이름</td>
//                                             <td>{info.name}</td>
//                                         </tr>

//                                         <tr>
//                                             <td style={Title}>전화번호</td>
//                                             <td>{info.phone}</td>
//                                         </tr>

//                                         <tr>
//                                             <td style={Title}>나이</td>
//                                             <td>{info.age}</td>
//                                         </tr>
//                                     </tbody>
//                                 </table>
//                             </div>
//                         )
//                     } else {
//                         // 관찰되는 요소가 없는 html
//                         return (
//                             <div style={Box} key={index}>
//                                 <table style={BoxTable} key={index}>
//                                     <tbody>
//                                         <tr>
//                                             <td style={Title}>이름</td>
//                                             <td>{info.name}</td>
//                                         </tr>

//                                         <tr>
//                                             <td style={Title}>전화번호</td>
//                                             <td>{info.phone}</td>
//                                         </tr>

//                                         <tr>
//                                             <td style={Title}>나이</td>
//                                             <td>{info.age}</td>
//                                         </tr>
//                                     </tbody>
//                                 </table>
//                             </div>
//                         )
//                     }
//                 })}
//         </div>
//     )
// }

// export default Test;
