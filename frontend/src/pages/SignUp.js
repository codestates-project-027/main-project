import styled from 'styled-components';
import icon from '../assets/logo/minimi-char.png';
import { useForm } from 'react-hook-form';
import { useRef } from 'react';
import { SignUpPageGlobal } from '../styles/globalStyle/PageGlobalStyle';

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
    <SignUpPageGlobal>
      <form onSubmit={handleSubmit(onSubmit)}>
        <div>
          <img className="logo" alt="logo" src={icon}></img>
        </div>
        <div className="signup-container">
          <div className="signup-info">
            <input
              style={{ textAlign: 'left' }}
              placeholder="이메일"
              name="email"
              {...register('email', {
                required: true,
                pattern: /\S+@\S+\.\S+/,
              })}
            />
            {errors.email && errors.email.type === 'pattern' && (
              <p className="email-confirm-message">
                올바른 이메일의 형식이 아닙니다
              </p>
            )}
            <input
              style={{ textAlign: 'left' }}
              placeholder="닉네임"
              name="username"
              {...register('username', {
                required: true,
                maxLength: 10,
                minLength: 2,
                pattern: /^[a-zA-Z0-9]*$/,
              })}
            />
            {errors.username && errors.username.type === 'minLength' && (
              <p className="id-message">
                닉네임은 2글자 이상, 10글자 이하이여야 합니다
              </p>
            )}
            {errors.username && errors.username.type === 'pattern' && (
              <p className="confirm-message">닉네임은 공백이 없어야 합니다</p>
            )}

            <input
              style={{ textAlign: 'left' }}
              placeholder="비밀번호"
              type="password"
              name="password"
              {...register('password', {
                required: true,
                minLength: 8,
                pattern: /^[a-zA-Z0-9]*$/,
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
            {errors.password && errors.password.type === 'pattern' && (
              <p className="password-message-length">
                비밀번호는 공백이 없어야 합니다
              </p>
            )}
            <input
              style={{ textAlign: 'left' }}
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
    </SignUpPageGlobal>
  );
};

export default SignupPage;
