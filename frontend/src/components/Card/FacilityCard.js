import styled from 'styled-components';
import { Link } from 'react-router-dom';

const FacilityCard = () => {
  return (
    <>
      <FCardStyle to="/facility">
        <FacilityCardStyle>
          <div className="img--wrapper">img</div>
          <div className="content--wrapper">
            <div className="name--wrapper">
              <Head1>name</Head1>
              <Head2>distance</Head2>
            </div>
            <div className="score--wrapper">
              <Head3>미니미만족도</Head3>
              <Stars>별 갯수</Stars>
            </div>
            <div className="tag--wrapper">
              <Head4>tags</Head4>
            </div>
          </div>
        </FacilityCardStyle>
      </FCardStyle>
    </>
  );
};

export default FacilityCard;

export const FCardStyle = styled(Link)`
  display: flex;
  align-items: center;
  margin: 8px;
  width: 37%;
  height: 20%;
  background-color: aliceblue;
  text-decoration: none;

  @media screen and (max-width: 3000px) {
    display: flex;
  }

  @media screen and (max-width: 790px) {
    display: none;
  }
`;

export const FacilityCardStyle = styled.div`
  display: flex;
  justify-content: center;
  align-items: center;
  width: 100%;
  height: 100%;

  .img--wrapper {
    display: flex;
    align-items: center;
    justify-content: center;
    margin-left: 15px;
    background-color: blanchedalmond;
    border-radius: 4px;
    width: 30%;
    height: 80%;
  }
  .content--wrapper {
    display: flex;
    justify-content: center;
    flex-direction: column;
    width: 70%;
    height: 85%;
    margin-left: 15px;
    background-color: bisque;
    border-radius: 3px;
    padding: 15px;
    .name--wrapper {
      display: flex;
      justify-content: space-between;
      margin-bottom: 20px;
    }
    .score--wrapper {
      display: flex;
      margin-bottom: 20px;
      .stars {
        display: flex;
      }
    }
    .tag--wrapper {
      display: flex;
    }
  }
  @media screen and (max-width: 3000px) {
    display: flex;
  }

  @media screen and (max-width: 790px) {
    display: none;
  }
`;

const Head1 = styled.div`
  font-size: 15px;
`;

const Head2 = styled.div`
  font-size: 15px;
  margin-right: 10px;
  @media screen and (max-width: 1097px) {
    margin-right: 5px;
  }
`;

const Head3 = styled.div`
  font-size: 15px;
  @media screen and (max-width: 1097px) {
    display: none;
  }
`;

const Head4 = styled.div`
  font-size: 15px;
`;

const Stars = styled.div`
  display: flex;
  margin-left: 20px;
  @media screen and (max-width: 1097px) {
    margin-left: 0;
  }
`;
