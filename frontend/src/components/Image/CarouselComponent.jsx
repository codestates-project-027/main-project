import { CarouselGlobal } from '../../styles/globalStyle/CarouselGlobalStyle';
import Carousel from 'react-material-ui-carousel';

export const CarouselComponent = ({ imgs }) => {
  return (
    <CarouselGlobal>
      <div className="window">
        <Carousel
          indicatorContainerProps={{
            style: {
              zIndex: 1000,
              position: 'relative',
            },
          }}
        >
          {imgs.map((item, i) => {
            return <img alt="facility" key={i} src={item} />;
          })}
        </Carousel>
      </div>
    </CarouselGlobal>
  );
};
