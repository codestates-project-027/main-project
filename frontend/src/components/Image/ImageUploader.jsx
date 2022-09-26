import ImageUploading from 'react-images-uploading';
import { useState } from 'react';
import styled from 'styled-components';

const ImageUploader = ({ images, setImages }) => {
  const maxNumber = 5;

  const onChange = (imageList) => {
    setImages(imageList);
  };

  return (
    <>
      <ImgUploaderStyle>
        <ImageUploading
          multiple
          value={images}
          onChange={onChange}
          maxNumber={maxNumber}
          dataURLKey="data_url"
        >
          {({
            imageList,
            onImageUpload,
            onImageRemoveAll,
            onImageUpdate,
            onImageRemove,
            dragProps,
          }) => (
            <>
              <div className="upload__image--wrapper">
                <button onClick={onImageUpload} {...dragProps}>
                  Click or Drop here
                </button>
                &nbsp;
                <button onClick={onImageRemoveAll}>Remove all images</button>
                <div className="img--wrapper">
                  {imageList.map((image, index) => (
                    <div key={index} className="image-item">
                      {index === 0 ? (
                        <>
                          <MainImg
                            src={image['data_url']}
                            alt=""
                            width="100px"
                            height="100px"
                          />
                          <BtnClose
                            className="remove"
                            onClick={() => onImageRemove(index)}
                          >
                            x
                          </BtnClose>

                          <BtnUpdate
                            className="update"
                            onClick={() => onImageUpdate(index)}
                          >
                            ⚙︎
                          </BtnUpdate>
                        </>
                      ) : (
                        <>
                          <Img
                            src={image['data_url']}
                            alt=""
                            width="100px"
                            height="100px"
                          />
                          <BtnClose
                            className="remove"
                            onClick={() => onImageRemove(index)}
                          >
                            x
                          </BtnClose>
                          <BtnUpdate
                            className="update"
                            onClick={() => onImageUpdate(index)}
                          >
                            ⚙︎
                          </BtnUpdate>
                        </>
                      )}
                    </div>
                  ))}
                </div>
              </div>
            </>
          )}
        </ImageUploading>
      </ImgUploaderStyle>
    </>
  );
};

export default ImageUploader;

const ImgUploaderStyle = styled.div`
  display: flex;
  justify-content: center;
  align-items: center;
  width: 500px;
  .img--wrapper {
    display: flex;
  }
`;

const BtnClose = styled.div`
  display: flex;
  width: 20px;
  height: 20px;
  justify-content: center;
  align-items: center;
  position: absolute;
  margin-top: -23px;
  cursor: pointer;
  background: rgba(155, 155, 155, 0.7);
  color: white;
  padding-left: 6px;
  padding-right: 6px;
  border-radius: 3px;
`;

const BtnUpdate = styled(BtnClose)`
  margin-left: 25px;
`;

const Img = styled.img`
  border: 1px solid lightgray;
`;

const MainImg = styled.img`
  border: 1px solid red;
`;
