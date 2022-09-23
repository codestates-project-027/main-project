import { useState } from 'react';
import { AiFillStar } from 'react-icons/ai';
import { StarsWrapper } from '../../styles/components/IconStyles';

const StarsCalc = ({ starValue }) => {
  const [stars, setStars] = useState(starValue);
  const arr = new Array(stars).fill(1);

  return (
    <>
      {arr.map((idx) => (
        <div key={idx}>
          <StarsWrapper>
            <AiFillStar size={20} fill="var(--logo-yellow)" />
          </StarsWrapper>
        </div>
      ))}
    </>
  );
};

export default StarsCalc;
