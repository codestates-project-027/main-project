import {
  combineReducers,
  configureStore,
  applyMiddleware,
} from '@reduxjs/toolkit';
import { createLogger } from 'redux-logger';
import ReduxThunk from 'redux-thunk';
import { categorySlice } from '../slices/categorySlice';
import { facilitySlice } from '../slices/facilitySlice';
import { composeWithDevTools } from 'redux-devtools-extension';

import storage from 'redux-persist/lib/storage';
import { persistReducer } from 'redux-persist';

const logger = createLogger();

const rootReducer = combineReducers({
  category: categorySlice.reducer,
  facility: facilitySlice.reducer
});

const persistConfig = { key: 'root', storage };
const persistedReducer = persistReducer(persistConfig, rootReducer);

const store = configureStore(
  {
    reducer: persistedReducer,
    middleware: (getDefaultMiddleware) =>
      getDefaultMiddleware({
        ReduxThunk: {}, //thunk
        serializableCheck: false,
      }).concat(logger),
  },
  // applyMiddleware(ReduxThunk),
  composeWithDevTools()
);

export default store;
