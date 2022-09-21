return (
  <div className="addPicture">
    <label
      htmlFor="input-file"
      className="addButton"
      onChange={handleAddImages}
    >
      <input type="file" id="input-file" multiple className="addButton" />
      <div fill="#646F7C" />
      <span>사진추가</span>
    </label>
    // 저장해둔 이미지들을 순회하면서 화면에 이미지 출력
    {imgPreview.map((image, id) => (
      <div className="imageContainer " key={id}>
        <img src={image} alt={`${image}-${id}`} />
        <div onClick={() => handleDeleteImage(id)}>x</div>
      </div>
    ))}
  </div>
);
