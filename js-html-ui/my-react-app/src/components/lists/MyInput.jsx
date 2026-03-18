import { useState } from "react";

export function MyInput() {

    const [input, setInput] = useState({name:"",location:""});

    const handleAddInput=(event)=>{
        setInput({...input,[event.target.name]:event.target.value});
        console.log(input);
    }

    const handleSubmit=()=>{
        console.log(input);
    }
    return (
        
        <>
        <form>
            <input type="text" value={input.name}  onChange={handleAddInput} name="name"/>
            <input type="text" value={input.location}  onChange={handleAddInput} name="location"/>
        </form>
        <button onClick={handleSubmit}>Submit</button>
        </>
    );
}