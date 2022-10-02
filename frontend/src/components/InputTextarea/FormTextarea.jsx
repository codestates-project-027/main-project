import {
  ReviewTXTStyle,
  CreateFTXTStyle,
} from '../../styles/components/InputTextareaStyle';
import { useState } from 'react';
import styled from 'styled-components';

export const Textarea = ({
  type,
  registerFac,
  setRegisterFac,
  value, setValue,
  mode,
}) => {
  //ReviewTXT : 리뷰 작성 textarea
  //FacilityTXT : 시설 등록 textarea

  const [count, setCount] = useState(0);
  const handleChange = (e) => {
    setRegisterFac({ ...registerFac, [e.target.name]: e.target.value });
    setCount(e.target.value.length);
  };

 const handleChangeReview = (e) => {
  setCount(e.target.value.length);
  setValue(e.target.value)
 }

  if (type === 'review') {
    return (
      <>
        <ReviewTXTStyle
          maxLength={100}
          onChange={(e) => handleChangeReview(e)}
          value={value}
        />
        <P marginBottom="20px">{count}/100</P>
      </> //desc 다시
    );
  } else if (type === 'facility') {
    return (
      <>
        <Div>
          <CreateFTXTStyle
            name="facilityInfo"
            maxLength={200}
            onChange={(e) => handleChange(e)}
            value={mode === 'edit' ? value : ''}
          />
          <P>{count}/200</P>
        </Div>
      </>
    );
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
