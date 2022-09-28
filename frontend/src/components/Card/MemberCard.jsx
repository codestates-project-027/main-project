import {
  MCardGlobal,
  MCardFlexGlobal,
} from '../../styles/globalStyle/CardGlobalStyle';

export const MemberCard = ({ Flex }) => {
  return Flex ? (
    <>
      <MCardFlexGlobal>member card</MCardFlexGlobal>
    </>
  ) : (
    <>
      <MCardGlobal>member card</MCardGlobal>
    </>
  );
};
