import { createRoot } from "react-dom/client";
import { CounterWithLifeCycle } from "./CounterWithLifeCycle";
import { StrictMode } from "react";



createRoot(document.getElementById('root')).render(
  <StrictMode>
    {/* <AgeCounter/> */}
    <CounterWithLifeCycle/>
   </StrictMode>
)
