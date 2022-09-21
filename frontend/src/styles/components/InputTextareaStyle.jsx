import styled from 'styled-components';

export const ReviewTXTStyle = styled.textarea`
  width: 350px;
  height: 200px;
  margin-top: 20px;
  margin-bottom: 20px;
  padding: 15px;
  text-align: left;
  &:focus {
    outline: transparent;
  }
`;

export const CreateFTXTStyle = styled(ReviewTXTStyle)`
  width: 430px;
`;
