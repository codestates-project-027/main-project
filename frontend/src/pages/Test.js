//거리계산 test
// import DistanceCalc from '../components/Calculator/DistanceCalc';

// const TestPage = () => {
//   return (
//     <DistanceCalc
//       currentLocation={{ latitude: 33.450701, longitude: 126.570667 }}
//       facilityLocation={'33.450936, 126.569477'} //생태연못
//       // facilityLocation={'33.458692, 126.618563'} //족은노루손이

//       //kakao스페이스 닷원~생태연못 거리 137m  / 직선거리 0.11km
//     />
//   );
// };

// export default TestPage;

//시설 생성 test

// import axios from 'axios';

// const TestPage = () => {
//   const onSubmit = async (e) => {
//     e.preventDefault();
//     e.persist();

//     let files = e.target.profile_files.files;

//     let formData = new FormData();

//     for (let i = 0; i < files.length; i++) {
//       formData.append('files', files[i]);
//     }

//     let dataSet = {
//       facilityName: '시설명',
//       facilityInfo: '시설정보',
//       address: '주소',
//       website: 'www',
//       phone: '010',
//       location: '35, 199',
//       categoryList: [],
//     };

//     formData.append('data', dataSet);

//     try {
//       // 415 (Unsupported Media Type) 에러
//       await axios.post(`https://minimi-place.duckdns.org/facility`, formData, {
//         headers: {
//           'Content-Type': 'multipart/form-data',
//         },
//       }).then(res=>console.log(res.data.headers))
//     } catch (err) {
//       console.log(err.data.headers);
//     }
//   };
//   return (
//     <form onSubmit={(e) => onSubmit(e)}>
//       <input type="file" name="profile_files" multiple="multiple" />

//       <button type="submit">제출</button>
//     </form>
//   );
// };

import axios from 'axios';

const TestPage = () => {
  let dataSet = {
    facilityName: '시설명',
    facilityInfo: '시설정보',
    address: '주소',
    website: 'www',
    phone: '010',
    location: '35, 199',
    categoryList: [],
  };
  //form Data
  const formData = new FormData();
  formData.append(
    'request',
    new Blob([JSON.stringify(dataSet)], { type: 'application/json' })
  );

  const postApi = async () => {
    try {
      // 415 (Unsupported Media Type) 에러
      await axios.post(`https://minimi-place.duckdns.org/facility`, formData, {
        headers: {
          'Content-Type': 'multipart/form-data',
        },
      }).then(res=>console.log(res))
    } catch (err) {
      console.log(err);
      console.log(err.response.headers);
    }
  };

  return (
    <>
      <button
        onClick={() => {
          postApi();
        }}
      >
        click
      </button>
    </>
  );
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
