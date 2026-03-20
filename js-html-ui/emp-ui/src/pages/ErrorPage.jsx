import { useLocation } from "react-router-dom";

export default function ErrorPage(){
    const location=useLocation();
    const error=location.state?.error;
    return(
        <>
        <h1>Error Occurred</h1>
        <h2>{error?.message}</h2>
        </>
    );
}