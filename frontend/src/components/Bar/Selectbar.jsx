import { useState } from 'react';
import { TagGroupX } from '../../components/Group/BtnAndTagGroup';

export const TagSelectbar = ({ data }) => {
  const [tagsList, setTagsList] = useState([]);
  const handleChangeSelect = (e) => {
    tagsList.push(e.target.value);
    console.log(tagsList);
  };
  return (
    <>
      <select onChange={handleChangeSelect}>
        {data.map((el, idx) => {
          return (
            <option value={el.categoryTitle} key={idx}>
              {el.categoryTitle}
            </option>
          );
        })}
      </select>
      <TagGroupX
        tags={tagsList}
        tagsList={tagsList}
        setTagsList={setTagsList}
      />
    </>
  );
};
