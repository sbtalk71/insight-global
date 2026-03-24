## Redux Toolkit – Setup & Usage Guide
### 1. What is Redux Toolkit?
Redux Toolkit (RTK) is the official, recommended way to write Redux logic. It simplifies Redux development by reducing boilerplate and providing powerful utilities.

### 2. Key Features:
- Simplified store setup
- Built-in support for immutability (via Immer)
- Pre-configured Redux DevTools
- Easy reducer & action creation

### 3. Installation
```bash
npm install @reduxjs/toolkit react-redux
```
### 4. Project Structure (Simple)
```sh
src/
 ├── app/
 │    └── store.js
 ├── features/
 │    └── counter/
 │         ├── counterSlice.js
 │         └── Counter.js
 ├── App.js
 └── index.js

```
### Step 1: Create Store
`app/store.js`
```js
import { configureStore } from '@reduxjs/toolkit';
import counterReducer from '../features/counter/counterSlice';

export const store = configureStore({
  reducer: {
    counter: counterReducer,
  },
});
```
### Step 2: Create Slice

A slice contains:
- State
- Reducers
- Actions

`features/counter/counterSlice.js`
```js
import { createSlice } from '@reduxjs/toolkit';

const initialState = {
  value: 0,
};

const counterSlice = createSlice({
  name: 'counter',
  initialState,
  reducers: {
    increment: (state) => {
      state.value += 1;
    },
    decrement: (state) => {
      state.value -= 1;
    },
    incrementByAmount: (state, action) => {
      state.value += action.payload;
    },
  },
});

export const { increment, decrement, incrementByAmount } = counterSlice.actions;

export default counterSlice.reducer;
```
### Step 3: Connect Store to React
`index.js`
```js
import React from 'react';
import ReactDOM from 'react-dom/client';
import App from './App';
import { store } from './app/store';
import { Provider } from 'react-redux';

const root = ReactDOM.createRoot(document.getElementById('root'));

root.render(
  <Provider store={store}>
    <App />
  </Provider>
);
```
### Step 4: Use Redux in Component
`features/counter/Counter.js`
```js
import React from 'react';
import { useSelector, useDispatch } from 'react-redux';
import { increment, decrement, incrementByAmount } from './counterSlice';

function Counter() {
  const count = useSelector((state) => state.counter.value);
  const dispatch = useDispatch();

  return (
    <div>
      <h2>Count: {count}</h2>

      <button onClick={() => dispatch(increment())}>
        Increment
      </button>

      <button onClick={() => dispatch(decrement())}>
        Decrement
      </button>

      <button onClick={() => dispatch(incrementByAmount(5))}>
        Add 5
      </button>
    </div>
  );
}

export default Counter;
```
### Step 5: Use Component in App
`App.js`
```js
import React from 'react';
import Counter from './features/counter/Counter';

function App() {
  return (
    <div>
      <h1>Redux Toolkit Example</h1>
      <Counter />
    </div>
  );
}

export default App;
```
### Flow of Redux Toolkit
User Action → dispatch() → Reducer → Store Update → UI Re-render

### Key Concepts Recap
| Concept     | Description                |
| ----------- | -------------------------- |
| Store       | Central state container    |
| Slice       | Combines reducer + actions |
| Reducer     | Updates state              |
| Action      | Describes what happened    |
| useSelector | Read state                 |
| useDispatch | Send actions               |

------END---------