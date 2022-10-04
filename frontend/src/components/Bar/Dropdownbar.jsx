import styled from 'styled-components';

export const DropDown = ({ options, handleDropDownClick, selected }) => {
  return (
    <DropDownContainer>
      {options.map((option, idx) => (
        <li
          key={idx}
          onClick={() => handleDropDownClick(option)}
          className={selected === idx ? 'selected' : ''}
        >
          {option}
        </li>
      ))}
    </DropDownContainer>
  );
};

export const DropDownContainer = styled.ul`
  background-color: #ffffff;
  display: flex;
  list-style-type: none;
  margin-top: -1px;
  padding: 0.5rem 0;
  border: 1px solid rgb(223, 225, 229);
  border-radius: 0 0 1rem 1rem;
  box-shadow: 2px 2px 2px lightgray;
  z-index: 3;
  width: 92.8%;
  margin-left: 20px;
  cursor: pointer;

  > li {
    padding: 0 1rem;
    text-align: left;
    width: 100%;

    &:hover {
      background-color: #eee;
    }

    &.selected {
      background-color: #ebe5f9;
    }
  }
`;
