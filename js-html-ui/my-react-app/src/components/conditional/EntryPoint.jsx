import { createRoot } from "react-dom/client";
import { StrictMode } from "react";
import LoginApp from "./LoginApp";

createRoot(document.getElementById('root')).render(
  <StrictMode>
    <LoginApp/>
   </StrictMode>,
)