import styled from 'styled-components';
import { PADDING } from '../../constants/style';

export const FCardStyle = styled.div`
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
    width: 170px;
    height: 110px;
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
      .name {
        font-size: 15px;
      }
      .distance {
        font-size: 15px;
        margin-right: 10px;
        @media screen and (max-width: 1097px) {
          margin-right: 5px;
        }
      }
    }
    .score--wrapper {
      display: flex;
      margin-bottom: 20px;
      .score {
        font-size: 15px;
        @media screen and (max-width: 1097px) {
          display: none;
        }
      }
      .stars {
        display: flex;
        margin-left: 20px;
        @media screen and (max-width: 1097px) {
          margin-left: 0;
        }
      }
    }
    .tag--wrapper {
      display: flex;
      .tags {
        font-size: 15px;
      }
    }
  }
  @media screen and (max-width: 3000px) {
    display: flex;
  }

  @media screen and (max-width: 790px) {
    display: none;
  }
`;

export const FCardFlexStyle = styled(FCardStyle)`
  @media screen and (max-width: 790px) {
    display: flex;
    width: 320px;
    margin-left: -25px;
    background-color: red;
  }
`;

export const FDescCardStyle = styled.div`
  display: flex;
  padding: ${PADDING.BASIC};
  background-color: lightyellow;
  justify-content: space-between;
  margin-bottom: 30px;
  .Fname {
    font-size: 1.1rem;
  }
  .remaining {
    display: flex;
    justify-content: right;
    font-size: 1rem;
    color: red;
  }
`;

export const AttendanceCardStyle = styled.div`
  display: flex;
  background-color: bisque;
  .wrapper {
    display: flex;
    align-items: flex-start;
    flex-direction: column;
  }
  .sub--wrapper {
    display: flex;
    color: red;
  }
  .label {
    display: flex;
    justify-content: center;
    align-items: center;
    width: 25px;
    height: 25px;
  }
  .day {
    display: flex;
    width: 25px;
    height: 25px;
    border: 1px solid lightpink;
  }
`;

export const AlarmCardStyle = styled.div`
  display: flex;
  justify-content: space-between;
  align-items: center;
  width: 350px;
  height: 70px;
  background-color: var(--main-navy);
  color: red;
  margin-bottom: 20px;
  border-radius: 5px;
  .icon--head--wrapper {
    display: flex;
    color: wheat;
    padding: ${PADDING.BASIC};
  }
  .date {
    color: wheat;
    padding: ${PADDING.BASIC};
  }
`;
