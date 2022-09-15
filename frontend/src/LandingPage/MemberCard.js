import styled from 'styled-components';
const MemberCard = () => {
  return (
    <>
      <MemberCardStyle>member card</MemberCardStyle>
    </>
  );
};
export default MemberCard;

const MemberCardStyle = styled.div`
  display: none;
  justify-content: center;
  align-items: center;
  width: 75%;
  height: 150px;
  background-color: var(--main-navy);
  color: wheat;
  margin-bottom: 30px;
  border-radius: 5px;
  @media screen and (max-width: 429px) {
    display: flex;
  }
`;
