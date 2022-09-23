import {
  ReviewTXTStyle,
  CreateFTXTStyle,
} from '../../styles/components/InputTextareaStyle';
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

export const FacilityDescForm = () => {
  const [count, setCount] = useState(0);
  return (
    <>
      <div
        style={{
          display: 'flex',
          flexDirection: 'column',
          alignItems: 'flex-end',
        }}
      >
        <CreateFTXTStyle
          maxLength={200}
          onChange={(e) => setCount(e.target.value.length)}
        />
        <p style={{}}>{count}/200</p>
      </div>
    </>
  );
};
