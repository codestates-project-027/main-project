import { useState } from 'react';
import { ReviewCardGlobal } from '../../styles/globalStyle/CardGlobalStyle';
import { ReviewCardStyle } from '../../styles/components/CardStyle';
import { H4 } from '../Text/Head';
import { IconWrapper } from '../../styles/components/IconStyles';
import CharLogo from '../../assets/logo/minimi-char2.png'

export const ReviewCard = ({review}) => {
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
          <div className="img--wrapper">
            <img src={CharLogo} width="60px" alt="review"/>
          </div>
          <div className="rest--wrapper">
            {isHover ? (
              <div className="edit--wrapper">
                <IconWrapper marginRight="3px">🖋</IconWrapper>
                <IconWrapper >✖️</IconWrapper>
                
              </div>
            ) : null}
            <div className="name--wrapper">
              <H4>{review.username}</H4>
              <div className="createdAt">{review.createdAt}</div>
            </div>
            <div className="content--wrapper">
            {review.contents}
            </div>
          </div>
        </ReviewCardStyle>
      </ReviewCardGlobal>
    </>
  );
};
