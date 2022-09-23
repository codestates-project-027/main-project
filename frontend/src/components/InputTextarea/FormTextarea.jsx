import {
  ReviewTXTStyle,
  CreateFTXTStyle,
} from '../../styles/components/InputTextareaStyle';
import { useState } from 'react';
import styled from 'styled-components';

export const ReviewTXT = () => {
  const [count, setCount] = useState(0);
  return (
    <>
      <ReviewTXTStyle
        maxLength={100}
        onChange={(e) => setCount(e.target.value.length)}
      />
      <P marginBottom="20px">{count}/100</P>
    </>
  );
};

export const FacilityDescForm = () => {
  const [count, setCount] = useState(0);
  return (
    <>
      <Div>
        <CreateFTXTStyle
          maxLength={200}
          onChange={(e) => setCount(e.target.value.length)}
        />
        <P>{count}/200</P>
      </Div>
    </>
  );
};

const Div = styled.div`
  display: flex;
  flex-direction: column;
  align-items: flex-end;
`;

const P = styled.p`
  margin-bottom: ${(props) => props.marginBottom || 0};
`;
