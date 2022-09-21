import { ReviewTXTStyle } from '../../styles/components/InputTextareaStyle';
import { useState } from 'react';

export const ReviewTXT = () => {
  const [count, setCount] = useState(0);
  return (
    <>
      <ReviewTXTStyle
        maxLength={100}
        onChange={(e) => setCount(e.target.value.length)}
      />
      <p style={{ marginBottom: '20px' }}>{count}/100</p>
    </>
  );
};
