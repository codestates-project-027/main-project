import { useState } from 'react';
import { ReviewCardGlobal } from '../../styles/globalStyle/CardGlobalStyle';
import { ReviewCardStyle } from '../../styles/components/CardStyle';
import { H4 } from '../Text/Head';
import { RiPencilFill } from 'react-icons/ri';
import { AiOutlineCloseSquare } from 'react-icons/ai';
import { IconWrapper } from '../../styles/components/IconStyles';

export const ReviewCard = () => {
  const [isHover, setIsHover] = useState(false);

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
          <div className="img--wrapper">img</div>
          <div className="rest--wrapper">
            {isHover ? (
              <div className="edit--wrapper">
                <IconWrapper marginRight="3px">🖋</IconWrapper>
                <IconWrapper >✖️</IconWrapper>
                
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
        </ReviewCardStyle>
      </ReviewCardGlobal>
    </>
  );
};
