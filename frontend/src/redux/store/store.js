import {
  combineReducers,
  configureStore,
  applyMiddleware,
} from '@reduxjs/toolkit';
import { createLogger } from 'redux-logger';
import ReduxThunk from 'redux-thunk';
import { categorySlice } from '../slices/categorySlice';
import { composeWithDevTools } from 'redux-devtools-extension';

const logger = createLogger();
const rootReducer = combineReducers({
  category: categorySlice.reducer,
});

const store = configureStore(
  {
    reducer: rootReducer,
  },
  applyMiddleware(logger, ReduxThunk),
  composeWithDevTools()
);

export default store;
