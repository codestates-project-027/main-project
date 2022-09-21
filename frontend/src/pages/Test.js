import { IoIosFitness } from 'react-icons/io';

const Test = () => {
  const arr = [<IoIosFitness size="23px" />, <IoIosFitness size="23px" />];

  return (
    <>
      {arr.map((el) => {
        return <div>{el}</div>;
      })}
    </>
  );
};

export default Test;
