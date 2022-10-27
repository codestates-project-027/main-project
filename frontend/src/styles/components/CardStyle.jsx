import styled from 'styled-components';
import { PADDING } from '../../constants/style';

export const FCardStyle = styled.div`
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
  width: 100%;
  margin-left: 20px;
  .wrapper {
    display: flex;
    align-items: center;
    width: 500px;
    height: 200px;
    background-color: #f8f7f7;
    margin: 0 0 20px 30px;
    border-radius: 8px;
    box-shadow: 2px 2px 2px lightgray;
    .img--wrapper {
      margin-left: 25px;
    }
    .content--wrapper {
      width: 100%;
      margin-left: 20px;
      .name--wrapper {
        display: flex;
        justify-content: space-between;
        margin: 0px 30px 25px 0;
      }
      .rest--wrapper {
        display: flex;
        flex-direction: column;
        width: 100%;
        justify-content: left;
      }
      .address {
        display: flex;
        margin-bottom: 10px;
      }
      .stars {
        display: flex;
      }
      .tags {
        display: flex;
        margin-left: -10px;
      }
    }
  }
  .contents {
    display: flex;
    flex-direction: column;
  }
  @media screen and (max-width: 476px) {
    .wrapper {
      width: 400px;

      .content--wrapper {
        width: 100%;
        margin-left: 10px;
        .name--wrapper {
          margin: 0px 10px 25px 0;
        }
        .rest--wrapper {
          .address {
            padding: 5px;
            text-align: left;
          }
        }
        .tags {
          width: 100%;
          margin-left: -5px;
        }
      }
    }
  }
`;

export const FCardFlexStyle = styled(FCardStyle)`
  @media screen and (max-width: 790px) {
    display: flex;
    width: 320px;
    margin-left: -25px;
    img {
      width: 150px;
      height: 130px;
    }
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
  background-color: #f3f3f3;
  .wrapper {
    display: flex;
    align-items: flex-start;
    flex-direction: column;
  }
  .sub--wrapper {
    display: flex;
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
    background-color: #caedfe;
    border-radius: 4px;
    width: 90px;
    height: 100px;
    margin-left: -20px;
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
      margin-bottom: 30px;
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
