import { useDispatch, useSelector } from 'react-redux';
import { useEffect } from 'react';
import { getTest } from '../redux/slices/testSlice';

const TestPage = () => {
  const dispatch = useDispatch();
  const testState = useSelector((state) => state.testSlice);

  useEffect(()=>{
    dispatch(getTest())
  },[])

  console.log(testState)
};

export default TestPage;

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
