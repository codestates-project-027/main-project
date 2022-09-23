import { useState } from 'react';
import { TagGroup } from '../../components/Group/BtnAndTagGroup';

export const TagSelectbar = ({ data }) => {
  const [tagsList, setTagsList] = useState([]);

  const handleChangeSelect = (e) => {
    const repeated = tagsList.filter((el) => el === e.target.value);
    if (
      e.target.value !== '' &&
      e.target.value !== '-' &&
      repeated.length === 0
    ) {
      setTagsList([...tagsList, e.target.value]);
    }
  };

  return (
    <>
      <select onChange={handleChangeSelect}>
        <option value={'-'}>---</option>
        {data.map((el, idx) => {
          return (
            <option value={el.categoryTitle} key={idx}>
              {el.categoryTitle}
            </option>
          );
        })}
      </select>
      <TagGroup
        tags={tagsList}
        tagsList={tagsList}
        setTagsList={setTagsList}
        close={'close'}
      />
    </>
  );
};
