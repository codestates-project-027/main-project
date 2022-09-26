import { useState } from 'react';

const TestPage = () => {
  const [inputs, setInputs] = useState({
    artistName: '',
    artistCompany: '',
    artistGenre: '',
    imageUri: '',
    description: '',
    realName: '',
    account: '',
    bank: '',
  });

  const {
    artistName,
    artistCompany,
    artistGenre,
    imageUri,
    description,
    realName,
    account,
    bank,
  } = inputs;

  const onChange = (e) => {
    setInputs({
      ...inputs,
      [e.target.name]: e.target.value,
    });
  };

  return (
    <>
      <div>
        <input name="artistName" value={artistName} onChange={onChange} />
        <br />
        <input name="artistCompany" value={artistCompany} onChange={onChange} />
        <br />
        <input name="artistGenre" value={artistGenre} onChange={onChange} />
        <br />
        <input name="imageUri" value={imageUri} onChange={onChange} />
        <br />
        <input
          name="description"
          style={{ width: '550px', height: '300px' }}
          value={description}
          onChange={onChange}
        />
        <br />
        <input name="realName" value={realName} onChange={onChange} />
        <br />
        <input name="account" value={account} onChange={onChange} />
        <br />
        <input name="bank" value={bank} onChange={onChange} />
        <br />
        <button onClick={()=>{console.log(inputs)}}>click</button>
      </div>
    </>
  );
};

export default TestPage;
