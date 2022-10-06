import { useState } from 'react';
import CharLogo from '../../assets/logo/minimi-char2.png';
import { ReviewCardGlobal } from '../../styles/globalStyle/CardGlobalStyle';
import { ReviewCardStyle } from '../../styles/components/CardStyle';
import { H4 } from '../Text/Head';
import { UReviewModal, ChoiceModal } from '../../components/Modal/ReviewModal';

export const ReviewCard = ({ review, fin, setFin }) => {
  const [isHover, setIsHover] = useState(false);
  const [RVcontents, setRVContents] = useState(review.contents);

  return (
    <>
      <ReviewCardGlobal>
        <ReviewCardStyle
          onMouseOver={() => {
            setIsHover(true);
          }}
          onMouseLeave={() => {
            setIsHover(false);
          }}
        >
          <div className="img--wrapper">
            <img src={CharLogo} width="60px" alt="review" />
          </div>
          <div className="rest--wrapper">
            {isHover ? (
              <div className="edit--wrapper">
                <UReviewModal
                  fin={fin}
                  setFin={setFin}
                  review={review}
                  type="reviewEdit"
                  RVcontents={RVcontents}
                  setRVContents={setRVContents}
                />
                <div style={{ marginLeft: '13px' }}>
                  <ChoiceModal
                    fin={fin}
                    setFin={setFin}
                    text={'삭제하시겠습니까?'}
                    btn={'✖️'}
                    review={review}
                  />
                </div>
              </div>
            ) : null}
            <div className="name--wrapper">
              <H4>{review.username}</H4>
              <div className="createdAt">{review.createdAt}</div>
            </div>
            <div className="content--wrapper">{review.contents}</div>
          </div>
        </ReviewCardStyle>
      </ReviewCardGlobal>
    </>
  );
};
