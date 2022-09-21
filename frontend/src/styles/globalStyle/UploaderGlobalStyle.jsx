import styled from 'styled-components';
export const ImgUploaderGlobal = styled.div`
  display: flex;
  flex-direction: column;
  width: 600px;
  background-color: red;
  .img--wrapper {
    display: flex;
    .remove {
      cursor: pointer;
    }
  }
  img {
    width: 100px;
    height: 100px;
  }
`;
