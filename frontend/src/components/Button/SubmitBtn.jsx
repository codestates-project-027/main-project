import {
  SubmitBtnStyle,
  DeleteBtnStyle,
} from '../../styles/components/BtnStyles';

export const SubmitBtn = ({ text }) => {
  return (
    <>
      <SubmitBtnStyle>{text}</SubmitBtnStyle>
    </>
  );
};

export const DeleteBtn = ({ text }) => {
  return (
    <>
      <DeleteBtnStyle>{text}</DeleteBtnStyle>
    </>
  );
};
