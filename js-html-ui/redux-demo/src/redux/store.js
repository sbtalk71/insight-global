import { configureStore } from "@reduxjs/toolkit";
import { icecreamReducer } from "./icecreamSlice.js";

export const store=configureStore({
    reducer:{
        icecreamSlice:icecreamReducer
    }
})