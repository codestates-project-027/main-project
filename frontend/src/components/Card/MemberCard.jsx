//합치고 싶은데 방법을 모르겠음.

import {
  MCardGlobal,
  MCardFlexGlobal,
} from '../../styles/globalStyle/CardGlobalStyle';

export const MemberCard = () => {
  //MemberCard -> Main (Page) // MCardGlobal
  //MemberCardFlex -> MyPage (Page) // MCardFlexGlobal

  return (
    <>
      <MCardGlobal>member card</MCardGlobal>
    </>
  );
};

export const MemberCardFlex = () => {
  return (
    <>
      <MCardFlexGlobal>member card</MCardFlexGlobal>
    </>
  );
};
