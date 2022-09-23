import { useState } from 'react';
import Box from '@mui/material/Box';
import Typography from '@mui/material/Typography';
import Modal from '@mui/material/Modal';
import { ModalBoxStyle } from '../../styles/components/Modalstyle';
import { ReviewTXT } from '../../components/InputTextarea/FormTextarea';
import { RoundBtn, BigBtn } from '../../components/Button/Btns';
import styled from 'styled-components';

//기능 구현 후 합칠 예정
export const CReviewModal = () => {
  const [open, setOpen] = useState(false);
  const handleOpen = () => setOpen(true);
  const handleClose = () => setOpen(false);

  return (
    <>
      <RoundBtn onClick={handleOpen}>리뷰 작성</RoundBtn>
      <Modal
        open={open}
        onClose={handleClose}
        aria-labelledby="modal-post-review"
        aria-describedby="modal-post-review"
      >
        <Box sx={ModalBoxStyle}>
          <Typography id="modal-modal-title" variant="h6" component="h2">
            리뷰 작성하기
          </Typography>
          <Div>
            <ReviewTXT />
            <BigBtn>리뷰 작성</BigBtn>
          </Div>
        </Box>
      </Modal>
    </>
  );
};

export const UReviewModal = () => {
  const [open, setOpen] = useState(false);
  const handleOpen = () => setOpen(true);
  const handleClose = () => setOpen(false);

  return (
    <div>
      <button //mui pen icon
        variant="contained"
        sx={{ borderRadius: '16px' }}
        color="yellow"
        style={{ width: '113px', marginBottom: '15px' }}
        onClick={handleOpen}
      />

      <Modal
        open={open}
        onClose={handleClose}
        aria-labelledby="modal-edit-review"
        aria-describedby="modal-edit-review"
      >
        <Box sx={ModalBoxStyle}>
          <Typography id="modal-modal-title" variant="h6" component="h2">
            리뷰 수정하기
          </Typography>
          <Div>
            <ReviewTXT /> {/*로컬스토리지로 클릭한 id의 내용 넣어주기*/}
            <BigBtn>리뷰 수정</BigBtn>
          </Div>
        </Box>
      </Modal>
    </div>
  );
};

const Div = styled.div`
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
`;
