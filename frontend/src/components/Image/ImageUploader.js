import { useState } from 'react';
import {
  ImgUploaderGlobal,
  ImgPreviewGlobal,
} from '../../styles/globalStyle/UploaderGlobalStyle';

const ImageUploader = () => {
  const [imgPreview, setImgPreview] = useState([]); //상대경로 필요
  const [mainImg, setMainImg] = useState(''); //대표이미지 설정
  const [isMainId, setIsMainId] = useState('');

  const handleAddImg = (e) => {
    const uploadedImgs = e.target.files;
    //파일 이름을 상대경로를 넣어서 처리하기 -> preview, axios
    const imgUrlLists = [...imgPreview];

    for (let i = 0; i < uploadedImgs.length; i++) {
      const imgUrl = URL.createObjectURL(uploadedImgs[i]);
      imgUrlLists.push(imgUrl);
    }

    if (imgUrlLists.length > 5) {
      imgUrlLists = imgUrlLists.slice(0, 5);
    }
    setImgPreview(imgUrlLists);
  };

  const handleDeleteImg = (id) => {
    setImgPreview(imgPreview.filter((_, idx) => idx !== id));
  };

  const handleMainImg = (id) => {
    setMainImg(imgPreview[id]);
    if (mainImg !== '') {
      setIsMainId(id);
      alert(`${id + 1}번째 이미지가 대표이미지로 설정되었습니다.`);
      console.log(mainImg);
    }
  };

  return (
    <>
      <ImgUploaderGlobal>
        <label htmlFor="img-input" onChange={handleAddImg}>
          <input type="file" id="img-input" multiple />
        </label>
        <div className="img--wrapper">
          {imgPreview.map((el, id) => (
            <div key={id}>
              {isMainId === id ? ( 
                <img
                  src={el}
                  alt={`facility-${id}`}
                  onClick={() => handleMainImg(id)}
                  style={{ border: '1px solid red' }}
                />
              ) : (
                <img
                  src={el}
                  alt={`facility-${id}`}
                  onClick={() => handleMainImg(id)}
                />
              )}

              <div className="remove" onClick={() => handleDeleteImg(id)}>
                x
              </div>
            </div>
          ))}
        </div>
      </ImgUploaderGlobal>
    </>
  );
};

export default ImageUploader;
