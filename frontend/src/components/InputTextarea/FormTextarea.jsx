import {
  ReviewTXTStyle,
  CreateFTXTStyle,
} from '../../styles/components/InputTextareaStyle';
import { useState } from 'react';
import styled from 'styled-components';

export const Textarea = ({
  placeholder,
  type,
  registerFac,
  setRegisterFac,
  value,
  setValue,
  mode,
  RVcontents,
  setRVContents,
  required,
}) => {
  const [count, setCount] = useState(0);
  const handleChange = (e) => {
    setRegisterFac({ ...registerFac, [e.target.name]: e.target.value });
    setCount(e.target.value.length);
  };

  const handleChangeReview = (e) => {
    if (type === 'review') {
      setCount(e.target.value.length);
      setValue(e.target.value);
    } else if (type === 'reviewEdit') {
      setCount(e.target.value.length);
      setRVContents(e.target.value);
    }
  };

  if (type === 'review') {
    return (
      <>
        <ReviewTXTStyle
          placeholder="시설 설명"
          required={required}
          maxLength={100}
          onChange={(e) => handleChangeReview(e)}
          value={value}
        />
        {count === 0 ? null : <P marginBottom="20px">{count}/100</P>}
      </>
    );
  } else if (type === 'reviewEdit') {
    return (
      <>
        <ReviewTXTStyle
          required={required}
          maxLength={100}
          onChange={(e) => handleChangeReview(e)}
          value={RVcontents}
        />
        {count === 0 ? null : <P marginBottom="20px">{count}/100</P>}
      </>
    );
  } else if (type === 'facility') {
    return (
      <>
        <Div>
          <CreateFTXTStyle
            placeholder="시설 설명"
            required={required}
            name="facilityInfo"
            maxLength={200}
            onChange={(e) => handleChange(e)}
            value={mode === 'edit' ? value : ''}
          />
          {count === 0 ? null : <P marginBottom="20px">{count}/100</P>}
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
