import {
  ReviewTXTStyle,
  CreateFTXTStyle,
} from '../../styles/components/InputTextareaStyle';
import { useState } from 'react';
import styled from 'styled-components';

export const Textarea = ({ type }) => {
  //ReviewTXT : 리뷰 작성 textarea
  //FacilityTXT : 시설 등록 textarea
  const [count, setCount] = useState(0);
  if (type === 'review') {
    return (
      <>
        <ReviewTXTStyle
          maxLength={100}
          onChange={(e) => setCount(e.target.value.length)}
        />
        <P marginBottom="20px">{count}/100</P>
      </>
    );
  } else if (type === 'facility') {
    <>
      <Div>
        <CreateFTXTStyle
          maxLength={200}
          onChange={(e) => setCount(e.target.value.length)}
        />
        <P>{count}/200</P>
      </Div>
    </>;
  }
};

const Div = styled.div`
  display: flex;
  flex-direction: column;
  align-items: flex-end;
`;

const P = styled.p`
  margin-bottom: ${(props) => props.marginBottom || 0};
`;
