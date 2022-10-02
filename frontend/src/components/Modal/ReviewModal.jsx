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

export const UReviewModal = ({ RVcontents, setRVContents, review }) => {
  const [open, setOpen] = useState(false);
  const { id } = useParams();
  const body = {
    reviewId: review.reviewId,
    contents: RVcontents,
  };

  //콘솔로그
  console.log(body);

  const editReview = async () => {
    await axiosInstance
      .patch('/review/' + id + '/' + review.reviewId, body)
      .then((res) => console.log(res.status));
    setOpen(false);
  };

  return (
    <div>
      <EditIcon variant="contained" onClick={() => setOpen(true)}>
        🖋
      </EditIcon>

      <Modal
        open={open}
        onClose={() => setOpen(false)}
        aria-labelledby="modal-edit-review"
        aria-describedby="modal-edit-review"
      >
        <Box sx={ModalBoxStyle}>
          <Typography id="modal-modal-title" variant="h6" component="h2">
            리뷰 수정하기
          </Typography>
          <Div>
            <Textarea
              type="reviewEdit"
              RVcontents={RVcontents}
              setRVContents={setRVContents}
            />
            <BigBtn
              onClick={() => {
                editReview();
              }}
            >
              리뷰 수정
            </BigBtn>
          </Div>
        </Box>
      </Modal>
    </div>
  );
};

export const ChoiceModal = ({ text, btn, review }) => {
  const [open, setOpen] = useState(false);
  const { id } = useParams();

  //delete RV
  const deleteReview = async () => {
    await axiosInstance
      .delete('/review/' + id + '/' + review.reviewId)
      .then((res) => console.log(res.status));
    setOpen(false);
  };

  return (
    <div>
      <EditIcon variant="contained" onClick={() => setOpen(true)}>
        {btn}
      </EditIcon>

      <Modal
        open={open}
        onClose={() => setOpen(false)}
        aria-labelledby="modal-delete-review"
        aria-describedby="modal-delete-review"
      >
        <Box sx={ModalBoxStyle}>
          <Typography id="modal-modal-title" variant="h6" component="h2">
            {text}
          </Typography>
          <Div flexDirection="row">
            <BigBtn
              marginRight="15px"
              onClick={() => {
                deleteReview();
              }}
            >
              예
            </BigBtn>
            <BigBtn onClick={() => setOpen(false)}>아니오</BigBtn>
          </Div>
        </Box>
      </Modal>
    </div>
  );
};

const Div = styled.div`
  display: flex;
  flex-direction: ${(props) => props.flexDirection || 'column'};
  justify-content: center;
  align-items: center;
`;

const EditIcon = styled.div`
  cursor: pointer;
`;
