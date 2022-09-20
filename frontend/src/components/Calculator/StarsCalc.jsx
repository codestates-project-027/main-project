import { useState } from 'react';
import { AiFillStar } from 'react-icons/ai';

const StarsCalc = ({ starValue }) => {
  const [stars, setStars] = useState(starValue);
  const arr = new Array(stars).fill(1);
  return (
    <>
      {arr.map((el, idx) => (
        <div key={idx}>
          <AiFillStar size={20} style={{ marginTop: '5px', fill: '#fae316' }} />
        </div>
      ))}
    </>
  );
};

export default StarsCalc;
