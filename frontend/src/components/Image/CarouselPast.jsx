import { CarouselGlobal } from '../../styles/globalStyle/CarouselGlobalStyle';
import { useState, useEffect, useRef } from 'react';

export const Carousel = ({ imgs }) => {
  const [currentPhoto, setCurrentPhoto] = useState(0);
  const photoRef = useRef(null);

  const NextPhoto = () => {
    if (currentPhoto >= imgs.length) {
      setCurrentPhoto(0);
    } else {
      setCurrentPhoto(currentPhoto + 1);
    }
  };

  const PrevPhoto = () => {
    if (currentPhoto === 0) {
      setCurrentPhoto(imgs.length);
    } else {
      setCurrentPhoto(currentPhoto - 1);
    }
  };

  useEffect(() => {
    photoRef.current.style.transform = `translateX(-${currentPhoto}00%)`;
  }, [currentPhoto]);

  return (
    <CarouselGlobal>
      <div className="window">
        <div className="img--wrapper">
          {imgs.map((el, idx) => {
            return (
              <div
                key={idx}
                className="img"
                style={{
                  backgroundImage: `url(${el})`,
                }}
              />
            );
          })}
        </div>
      </div>
      <button onClick={PrevPhoto}>prev</button>
      <button onClick={NextPhoto}>next</button>
    </CarouselGlobal>
  );
};
