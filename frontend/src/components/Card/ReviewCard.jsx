import { ReviewCardGlobal } from '../../styles/globalStyle/CardGlobalStyle';
import { RCardStyle } from '../../styles/components/CardStyle';
import { H4 } from '../Text/Head';
import { RiPencilFill } from 'react-icons/ri';
import { AiOutlineCloseSquare } from 'react-icons/ai';
import { useState } from 'react';

export const ReviewCard = () => {
  const [isHover, setIsHover] = useState(false);
  const hoverOn = () => {
    setIsHover(true);
  };
  const hoverOff = () => {
    setIsHover(false);
  };
  return (
    <>
      <ReviewCardGlobal>
        <RCardStyle onMouseOver={hoverOn} onMouseLeave={hoverOff}>
          <div className="img--wrapper">img</div>
          <div className="rest--wrapper">
            {isHover ? (
              <div className="edit--wrapper">
                <RiPencilFill style={{ marginRight: '15px' }} />
                <AiOutlineCloseSquare />
              </div>
            ) : null}
            <div className="name--wrapper">
              <H4>username</H4>
              <div className="createdAt">날짜</div>
            </div>
            <div className="content--wrapper">
              내용 내용 내용 내용 내용 내용 내용 내용 내용 내용 내용 내용 내용
              내용 내용 내용 내용 내용 내용 내용 내용 aasefas
            </div>
          </div>
        </RCardStyle>
      </ReviewCardGlobal>
    </>
  );
};
