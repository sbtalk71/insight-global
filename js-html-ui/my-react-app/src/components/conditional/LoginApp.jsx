import { useState } from "react";
import { Admin } from "./Admin";
import { User } from "./User";

let LoginApp=()=>{

    const [admin,setAdmin]=useState(true);
    
   let toggleAdmin=()=>{
        if(admin){
            setAdmin(false);
        }else{
            setAdmin(true);
        }
    }
    
    return(
        <>
        <button onClick={toggleAdmin}>Toggle</button>
        {admin?<Admin/>:<User/>}
        </>
    );
}

export default LoginApp;