import { createRoot } from "react-dom/client";
import { StrictMode } from "react";
import { Greet } from "./Greet";

createRoot(document.getElementById('root')).render(
  <StrictMode>
    <Greet/>
   </StrictMode>,
)