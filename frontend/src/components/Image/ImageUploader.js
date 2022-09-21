import { useState } from 'react';
import { ImgUploaderGlobal } from '../../styles/globalStyle/UploaderGlobalStyle';

const ImageUploader = () => {
  const [imgPreview, setImgPreview] = useState([]); //상대경로 필요

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

  return (
    <>
      <ImgUploaderGlobal>
        <label
          style={{ background: 'yellow' }}
          htmlFor="img-input"
          onChange={handleAddImg}
        >
          <input type="file" id="img-input" multiple />
        </label>
        {imgPreview.map((el, id) => (
          <div className="img--wrapper" key={id}>
            <img src={el} alt={`facility-${id}`} />
            <div className="remove" onClick={() => handleDeleteImg(id)}>
              x
            </div>
          </div>
        ))}
      </ImgUploaderGlobal>
    </>
  );
};

export default ImageUploader;
