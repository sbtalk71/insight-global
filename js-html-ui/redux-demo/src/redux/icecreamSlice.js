import { createSlice } from "@reduxjs/toolkit";

export const icecreamSlice=createSlice({
    name:"icecreamSlice",
    initialState: {
        icecream:20
    },
    reducers:{
        buyIceCream:(state,action)=>{state.icecream=state.icecream-action.payload},
        stockIcecream: (state,action)=>{state.icecream=state.icecream+Number(action.payload)}

    }
});

export const {buyIceCream,stockIcecream}=icecreamSlice.actions;
export const icecreamReducer=icecreamSlice.reducer;
