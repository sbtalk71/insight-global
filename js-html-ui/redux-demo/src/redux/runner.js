import { buyIceCream, stockIcecream } from "./icecreamSlice.js";
import { store } from "./store.js";

const unsubscribe=store.subscribe(()=>console.log("Store updated : ",store.getState()));

store.dispatch(buyIceCream(2));
store.dispatch(buyIceCream(1));
store.dispatch(buyIceCream(3));
store.dispatch(buyIceCream(2));
store.dispatch(stockIcecream(10));
unsubscribe()
