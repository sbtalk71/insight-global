import axios from 'axios';
import 'bootstrap/dist/css/bootstrap.min.css';
import { useEffect, useState } from 'react';
import { useParams } from 'react-router-dom';
import { Link } from 'react-router-dom';

export function EmployeeDetails(){
    const {id}=useParams();
    const [employee,setEmployee]=useState({});
    useEffect(()=>{
        axios.get("http://localhost:8081/emp/"+id)
        .then(resp=>setEmployee(resp.data))
        .catch(err=>console.log(err));
    })
     return (
        <div className="card" style={{width: "18rem"}}>
            <div className="card-body">
                <h5 className="card-title">{employee.name}</h5>
                <h6 className="card-subtitle mb-2 text-body-secondary">{employee.city}</h6>
                <p className="card-text">{employee.deptNo}</p>
                <p className="card-text">{employee.salary}</p>
                <Link to="/employees" className="card-link">back to List</Link>
            </div>
        </div>
    );
}