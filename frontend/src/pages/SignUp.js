import styled from 'styled-components';
import icon from '../assets/icon/미니미캐릭터.png';
import { useForm } from 'react-hook-form';
import { useRef } from 'react';

const SignupPage = () => {
  const {
    register,
    handleSubmit,
    watch,
    formState: { errors },
  } = useForm();

  const password = useRef();
  password.current = watch('password');

  const onSubmit = (data) => {
    console.log('data', data);
  };

  // axios

  return (
    <SignupWrapper>
      <form onSubmit={handleSubmit(onSubmit)}>
        <div>
          <img className="logo" alt="logo" src={icon}></img>
        </div>
        <div className="signup-container">
          <div className="signup-info">
            <input
              placeholder="아이디"
              name="nickname"
              {...register('nickname', {
                required: true,
                maxLength: 10,
                minLength: 2,
              })}
            />
            {errors.nickname && (
              <p className="id-message">
                아이디는 2글자 이상, 10글자 이하이여야 합니다
              </p>
            )}
            <input
              placeholder="비밀번호"
              type="password"
              name="password"
              {...register('password', {
                required: true,
                minLength: 8,
              })}
            />
            {errors.password && errors.password.type === 'required' && (
              <p className="password-message">비밀번호를 입력해주세요</p>
            )}
            {errors.password && errors.password.type === 'minLength' && (
              <p className="password-message-length">
                비밀번호는 8자리 이상이여야 합니다
              </p>
            )}
            <input
              placeholder="비밀번호 확인"
              name="password_confirm"
              type="password"
              {...register('password_confirm', {
                required: true,
                validate: (value) => value === password.current,
              })}
            />
            {errors.password_confirm &&
              errors.password_confirm.type === 'validate' && (
                <p className="confirm-message">비밀번호가 일치하지 않습니다</p>
              )}
          </div>
          <div className="signup-button">
            <button type="submit">회원가입</button>
          </div>
        </div>
      </form>
    </SignupWrapper>
  );
};

export default SignupPage;

const SignupWrapper = styled.div`
  display: flex;
  flex-direction: column;
  .logo {
    width: 10vh;
  }
  .signup-container {
    padding: 1rem;
  }

  .signup-info {
    display: flex;
    flex-direction: column;
    align-items: center;
    width: 15rem;
    height: 15rem;
  }

  input {
    margin: 1rem;
    padding: 0.5rem;
    width: 20rem;
    height: 5vh;
  }

  .password-message {
    color: red;
    font-size: 10px;
    position: relative;
    bottom: 1vh;
    right: 6.5rem;
  }

  .password-message-length {
    color: red;
    font-size: 10px;
    position: relative;
    bottom: 1vh;
    right: 5rem;
  }

  .id-message {
    color: red;
    font-size: 10px;
    position: relative;
    bottom: 1vh;
    right: 3.7rem;
  }
  .confirm-message {
    color: red;
    font-size: 10px;
    position: relative;
    bottom: 1vh;
    right: 6rem;
  }

  button {
    border: 1px solid var(--main-yellow);
    border-radius: 0.6rem;
    background-color: var(--main-yellow);
    margin: 0.7rem;
    width: 7rem;
    height: 2.5rem;
  }
`;
