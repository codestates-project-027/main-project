import styled from 'styled-components';
export const ImgUploaderGlobal = styled.div`
  display: flex;
  flex-direction: column;
  width: 430px;
  margin-left: 45px;
  margin-top: 30px;
  margin-bottom: 30px;
  label {
    background: lightgreen;
    border-radius: 3px;
  }
  .img--wrapper {
    display: flex;
    .remove {
      display: flex;
      position: absolute;
      margin-top: -20px;
      cursor: pointer;
      background: #9b9b9b;
      color: white;
      padding-left: 6px;
      padding-right: 6px;
      border-radius: 3px;
      height: fit-content;
    }
  }
  img {
    width: 86px;
    height: 86px;
  }
`;
