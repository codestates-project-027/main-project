import styled from 'styled-components';

export const FCardGlobal = styled.div`
  display: flex;
  align-items: center;
  margin: 8px;
  width: 37%;
  height: 20%;
  text-decoration: none;

  @media screen and (max-width: 3000px) {
    display: flex;
  }

  @media screen and (max-width: 790px) {
    display: none;
  }
`;

export const FCardFlexGlobal = styled(FCardGlobal)`
  @media screen and (max-width: 790px) {
    display: flex;
    width: 250px;
  }
`;

export const MCardGlobal = styled.div`
  display: none;
  justify-content: center;
  align-items: center;
  width: 350px;
  height: 200px;
  background-color: var(--main-navy);
  color: wheat;
  margin-top: 50px;
  margin-bottom: 50px;
  border-radius: 5px;
  @media screen and (max-width: 790px) {
    //429px
    display: flex;
    div {
    color: wheat;
    color: var(--main-yellow);
  }
  .wrapper {
    display: flex;
    align-items: center;
    justify-content: space-between;
    width: 100%;
    padding: 30px;
    .img--wrapper {
      width: 30%;
      img {
        border: 5px solid #454546;
        border-radius: 8px;
      }
    }
    .content--wrapper {
      display: flex;
      flex-direction: column;
      align-items: flex-start;
      text-align: left;
      width: 60%;
      text-align: left;
      div:nth-child(1) {
        margin-bottom: 20px;
        font-weight: bold;
        font-size: 1.2rem;
      }
      div:nth-child(2) {
        margin-bottom: 20px;
      }
    }
  }
  }
`;

export const MCardFlexGlobal = styled(MCardGlobal)`
  div {
    color: wheat;
    color: var(--main-yellow);
  }
  .wrapper {
    display: flex;
    align-items: center;
    justify-content: space-between;
    width: 100%;
    padding: 30px;
    .img--wrapper {
      width: 30%;
      img {
        border: 5px solid #454546;
        border-radius: 8px;
      }
    }
    .content--wrapper {
      display: flex;
      flex-direction: column;
      align-items: flex-start;
      text-align: left;
      width: 60%;
      text-align: left;
      div:nth-child(1) {
        margin-bottom: 20px;
        font-weight: bold;
        font-size: 1.2rem;
      }
      div:nth-child(2) {
        margin-bottom: 20px;
      }
    }
  }

  @media screen and (min-width: 790px) {
    display: flex;
  }
`;

export const AlarmCardGlobal = styled.div`
  display: flex;
  justify-content: center;
  align-items: center;
  width: 100%;
`;

export const ReviewCardGlobal = styled.div`
  display: flex;
  background: #f3f3f3;
  border-bottom: 1px solid #dbdbdb;
  margin: 10px 0 17px 0;
`;

export const CommunityCardGlobal = styled.div`
  display: flex;
  align-items: center;
  width: 600px;
  height: 100px;
  color: yellow;
  font-size: 10px;
  background-color: var(--main-navy);
  border-radius: 10px;
`;
