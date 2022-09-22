import { useState } from 'react';
import Box from '@mui/material/Box';
import Button from '@mui/material/Button';
import Typography from '@mui/material/Typography';
import Modal from '@mui/material/Modal';
import { ModalBoxStyle } from '../../styles/components/Modalstyle';
import { SubmitBtn } from '../../components/Button/SubmitBtn';
import { ReviewTXT } from '../../components/InputTextarea/FormTextarea';

export const CReviewModal = () => {
  const [open, setOpen] = useState(false);
  const handleOpen = () => setOpen(true);
  const handleClose = () => setOpen(false);

  return (
    <div>
      <Button
        variant="contained"
        sx={{ borderRadius: '16px' }}
        color="yellow"
        style={{ width: '113px', marginBottom: '15px' }}
        onClick={handleOpen}
      >
        리뷰 작성
      </Button>
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
          <div
            style={{
              display: 'flex',
              flexDirection: 'column',
              justifyContent: 'center',
              alignItems: 'center',
            }}
          >
            <ReviewTXT />
            <SubmitBtn text={'리뷰 작성'} />
          </div>
        </Box>
      </Modal>
    </div>
  );
};

export const UReviewModal = () => {
  const [open, setOpen] = useState(false);
  const handleOpen = () => setOpen(true);
  const handleClose = () => setOpen(false);

  return (
    <div>
      <Button //mui pen icon
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
          <div
            style={{
              display: 'flex',
              flexDirection: 'column',
              justifyContent: 'center',
              alignItems: 'center',
            }}
          >
            <ReviewTXT /> {/*로컬스토리지로 클릭한 id의 내용 넣어주기*/}
            <SubmitBtn text={'리뷰 수정'} />
          </div>
        </Box>
      </Modal>
    </div>
  );
};
