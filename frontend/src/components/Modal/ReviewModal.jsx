import axiosInstance from '../../api/Interceptor';
import styled from 'styled-components';
import { useState, useEffect, useCallback } from 'react';
import { useParams } from 'react-router-dom';
import { useDispatch, useSelector } from 'react-redux';
import Typography from '@mui/material/Typography';
import Modal from '@mui/material/Modal';
import Box from '@mui/material/Box';
import { ModalBoxStyle } from '../../styles/components/Modalstyle';
import { Textarea } from '../InputTextarea/FormTextarea';
import { RoundBtn, BigBtn } from '../Button/Btns';

//기능 구현 후 합칠 예정
export const CReviewModal = ({ setReview }) => {
  const [open, setOpen] = useState(false);
  const [value, setValue] = useState('');
  const { id } = useParams();
  const body = {
    facilityId: id,
    username: '미니미회원',
    contents: value,
  };

  // const getReview = async () => {
  //   await axiosInstance.get('/review/' + id + '?page=1').then((res) => {
  //     dispatch(getReview({ list: res.data }));
  //   });
  // };

  const getReview = async () => {
    await axiosInstance.get('/review/' + id + '?page=1').then((res) => {
      setReview(res.data);
    });
  };

  const createReview = async () => {
    await axiosInstance
      .post('/review', body)
      .then((res) => console.log(res.status));
    setOpen(false);
  };

  useEffect(() => {
    getReview();
  }, [setOpen]);

  return (
    <>
      <RoundBtn
        onClick={() => {
          setOpen(true);
        }}
      >
        리뷰 작성
      </RoundBtn>
      <Modal
        open={open}
        onClose={() => {
          setOpen(false);
        }}
        aria-labelledby="modal-post-review"
        aria-describedby="modal-post-review"
      >
        <Box sx={ModalBoxStyle}>
          <Typography id="modal-modal-title" variant="h6" component="h2">
            리뷰 작성하기
          </Typography>
          <Div>
            <Textarea type="review" value={value} setValue={setValue} />
            <BigBtn
              onClick={() => {
                createReview();
              }}
            >
              리뷰 작성
            </BigBtn>
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
            <Textarea type="review" />{' '}
            {/*로컬스토리지로 클릭한 id의 내용 넣어주기*/}
            <BigBtn>리뷰 수정</BigBtn>
          </Div>
        </Box>
      </Modal>
    </div>
  );
};

export const ImgUploadModal = () => {
  const [open, setOpen] = useState(false);

  return (
    <>
      <button>업로드</button>
      <Modal
        open={open}
        onClose={() => {
          setOpen(false);
        }}
        aria-labelledby="modal-upload-img"
        aria-describedby="modal-upload-img"
      >
        <Box sx={ModalBoxStyle}>이미지 모음</Box>
      </Modal>
    </>
  );
};

const Div = styled.div`
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
`;
