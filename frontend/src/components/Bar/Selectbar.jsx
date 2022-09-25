import { useState } from 'react';
import { TagGroup } from '../../components/Group/BtnAndTagGroup';
import styled from 'styled-components';

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
      {tagsList.length < 4 ? (
        <>
          <Select onChange={handleChangeSelect}>
            <option value={'-'}>---</option>
            {data.map((el, idx) => {
              return (
                <option value={el.categoryTitle} key={idx}>
                  {el.categoryTitle}
                </option>
              );
            })}
          </Select>
          <TagGroupWrapper>
            <TagGroup
              tags={tagsList}
              tagsList={tagsList}
              setTagsList={setTagsList}
              close={'close'}
            />
          </TagGroupWrapper>
        </>
      ) : (
        <Div>
          <Select onChange={handleChangeSelect}>
            <option value={'-'}>---</option>
            {data.map((el, idx) => {
              return (
                <option value={el.categoryTitle} key={idx}>
                  {el.categoryTitle}
                </option>
              );
            })}
          </Select>
          <TagGroupWrapper>
            <TagGroup
              tags={tagsList}
              tagsList={tagsList}
              setTagsList={setTagsList}
              close={'close'}
            />
          </TagGroupWrapper>
        </Div>
      )}
    </>
  );
};

const Div = styled.div`
  display: flex;
  flex-direction: column;
`;

const TagGroupWrapper = styled.div`
  display: flex;
  flex-wrap: wrap;
`;

const Select = styled.select`
  width: 80px;
`;
