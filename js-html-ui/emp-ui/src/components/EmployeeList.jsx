import axios from "axios";
import { useEffect, useState } from "react";

export function EmployeeList() {

    const [employees, setEmployees] = useState([]);
    
    useEffect(() => {
        axios.get("http://localhost:8081/emp/")
            .then(response => setEmployees(response.data))
            .catch(err => console.log(err));
    }, []);

    return (
        <>
        
        </>
    )
        
}