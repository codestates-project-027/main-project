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
  margin-bottom: 10px;
  border-radius: 5px;
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

export const LocationViewCardStyle = styled.div`
  display: flex;
  width: 100%;
  height: 100%;
  margin: 20px;
  min-width: 350px;
  min-height: 150px;
  background-color: lightgoldenrodyellow;
`;

export const ReviewCardStyle = styled.div`
  display: flex;
  justify-content: center;
  align-items: center;
  width: 100%;
  .img--wrapper {
    display: flex;
    align-items: center;
    justify-content: center;
    margin-top: 10px;
    background-color: lightblue;
    border-radius: 4px;
    width: 170px;
    height: 110px;
  }
  .rest--wrapper {
    display: flex;
    justify-content: center;
    flex-direction: column;
    width: 350px;
    height: fit-content;
    margin-left: 15px;
    background-color: light;
    border-radius: 3px;
    padding: 15px;
    .edit--wrapper {
      display: flex;
      justify-content: right;
      margin-bottom: 20px;
    }
    .name--wrapper {
      display: flex;
      justify-content: space-between;
      margin-bottom: 20px;
      .createdAt {
        font-size: 15px;
        margin-right: 10px;
      }
    }
    .content--wrapper {
      display: inline-block;
      text-align: left;
      margin-bottom: 20px;
      white-space: normal;
      overflow-wrap: break-word;
    }
  }
`;

//community

export const UserImageCard = styled.div`
  border: 1px solid white;
  width: 5rem;
  height: 5rem;
  margin: 1rem;
`;

export const Posting = styled.div`
  .content--wrapper {
    margin-top: 0.2rem;
    margin-right: 7rem;
    height: 5rem;
    width: 8rem;
    .name--wrapper {
      display: flex;
      position: relative;
      right: 1.5rem;
    }
    .post {
      display: flex;
      position: relative;
      width: 100%;
      height: 100%;
      bottom: 4rem;
      right: 1.5rem;
    }
  }
`;

export const Location = styled.div`
  margin-top: 5rem;
  margin-right: 1rem;
`;
