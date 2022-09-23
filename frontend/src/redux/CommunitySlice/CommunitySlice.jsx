//slice가 하는일 : 리듀서(어떻게 수정할건지) 만드는 걸 도와줌

import { createSlice } from '@reduxjs/toolkit';

const initialState = [
  { id: '1', username: '내가만든쿠키', content: '플로깅 하실분' },
  { id: '2', username: '한강에서하자', content: '플로깅이 뭐죠?' },
];

const communitySlice = createSlice({
  name: 'username',
  postings: 'postings',
  initialState,
});

export default communitySlice.reducer;
