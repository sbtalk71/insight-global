import { createRoot } from "react-dom/client";
import { StrictMode } from "react";
import { EmpCard } from "./EmpCard";

createRoot(document.getElementById('root')).render(
  <StrictMode>
  <EmpCard/>
   </StrictMode>,
)