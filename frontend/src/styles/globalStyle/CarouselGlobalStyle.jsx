import styled from 'styled-components';

export const CarouselGlobal = styled.div`
  transition: all 0.3s ease-out;
  display: flex;
  justify-content: center;
  align-items: center;

  .window {
    background: #f3f3f3;
    width: 550px;
    height: 350px;
    overflow: hidden;
    border-radius: 3px;
  }

  .img--wrapper {
    display: flex;
  }

  /* .img {
    width: 550px;
    height: 300px;
    background-position: 50% 50%;
    background-size: contain;
    background-repeat: no-repeat;
    flex: none;
  } */
  img {
    background-color: #aefaae;
    width: 550px;
    height: 300px;
    object-fit: contain;
    flex: none;
  }
  @media screen and (max-width: 1000px) {
    display: flex;
    width: 100%;
    .window {
      background: #f3f3f3;
      width: 80%;
      height: 350px;
      overflow: hidden;
      border-radius: 3px;
    }
    img {
      width: 100%;
      height: 300px;
    }
  }
  @media screen and (max-width: 476px) {
    display: flex;
    margin-left: -20px;
    width: 400px;
    .window {
      background: #f3f3f3;
      width: 330px;
      height: 350px;
      overflow: hidden;
      border-radius: 3px;
    }
    img {
      width: 300px;
      height: 300px;
    }
  }
`;
