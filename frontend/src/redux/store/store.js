import {
  combineReducers,
  configureStore,
  applyMiddleware,
} from '@reduxjs/toolkit';
import { createLogger } from 'redux-logger';
import ReduxThunk from 'redux-thunk';
import { categorySlice } from '../slices/categorySlice';
import { communitySlice } from '../CommunitySlice/CommunitySlice';

const logger = createLogger();
const rootReducer = combineReducers({
  category: categorySlice.reducer,
  community: communitySlice.reducer,
});

const store = configureStore(
  {
    reducer: rootReducer,
  },
  applyMiddleware(logger, ReduxThunk)
);

export default store;
