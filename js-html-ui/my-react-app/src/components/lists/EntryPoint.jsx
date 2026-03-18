import { createRoot } from "react-dom/client";

import { StrictMode } from "react";
import { FruitsList } from "./FruitsList";
import { MyInput } from "./MyInput";
import TodoApp from "./ToDos";

const fruits=["Apple","Orange","Guava","Grapes","Mango"];
const birds=["sparrow","Parrot","Peacock","Rooster","Crow"];
createRoot(document.getElementById('root')).render(
  
  <StrictMode>
    {/* <FruitsList data={fruits}/>
    <FruitsList data={birds}/> */}
    {/* <MyInput/> */}
    <TodoApp/>
   </StrictMode>,
)