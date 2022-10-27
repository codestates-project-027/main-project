import {
  combineReducers,
  configureStore,
  // applyMiddleware,
} from '@reduxjs/toolkit';
// import { createLogger } from 'redux-logger';
// import ReduxThunk from 'redux-thunk';
import { categorySlice } from '../slices/categorySlice';
import { communitySlice } from '../CommunitySlice/CommunitySlice';
import { facilitySlice } from '../slices/facilitySlice';
import { locationSlice } from '../slices/locationSlice';
import { testSlice } from '../slices/testSlice';

import { composeWithDevTools } from 'redux-devtools-extension';

import storage from 'redux-persist/lib/storage';
import { persistReducer } from 'redux-persist';

// const logger = createLogger();

const rootReducer = combineReducers({
  category: categorySlice.reducer,
  community: communitySlice.reducer,
  facility: facilitySlice.reducer,
  location: locationSlice.reducer,
  test: testSlice.reducer,
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
      })
      // .concat(logger),
  },
  // applyMiddleware(ReduxThunk),
  composeWithDevTools()
);

export default store;
