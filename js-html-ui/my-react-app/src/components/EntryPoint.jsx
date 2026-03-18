import { createRoot } from "react-dom/client";
import { Hello } from "./Hello";
import { StrictMode } from "react";

createRoot(document.getElementById('root')).render(
  <StrictMode>
    <Hello/>
   </StrictMode>,
)