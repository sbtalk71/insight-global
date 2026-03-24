import { useState } from "react"
import { useDispatch, useSelector } from "react-redux";
import { buyIceCream, stockIcecream } from "./icecreamSlice.js";
import { store } from "./store.js";

export function IceCream() {

    const [icecreams, setIceCreams] = useState(0);
    const dispatch = useDispatch();
    const iceCreamsCount=useSelector(store=>store.icecreamSlice.icecream);

    const handleBuy = () => {
        dispatch(buyIceCream(icecreams));
    }
    const handleStock = () => {
        dispatch(stockIcecream(parseInt(icecreams)));
    }

    const handleChange = (event) => {
        setIceCreams(event.target.value);
    }
    return (
        <>
            <input type="text" value={icecreams} onChange={handleChange}/>
            <button onClick={handleBuy}>Buy</button>
             <button onClick={handleStock}>Stock</button>
            <hr></hr>
            <h2> Balance Stocke : {iceCreamsCount}</h2>
        </>
    )
}