import axios from "axios";
import { useEffect, useState } from "react";
import 'bootstrap/dist/css/bootstrap.min.css';
import { Link, useNavigate } from "react-router-dom";

export function EmployeeList() {

    const [employees, setEmployees] = useState([]);
   

    const navigate=useNavigate();

    useEffect(() => {
        axios.get("http://localhost:8081/emp")
            .then(response => setEmployees(response.data))
            .catch(err => navigate("/error",err));
    }, []);

    const handleRowClick=(id)=>{
        navigate('./'+id);
    }

    const handleEditBtn=(id)=>{
            navigate(`/editEmployee/${id}`);
    }
    const handleDelete=(empId)=>{
        const del=window.confirm("Do you really want to delete");
        if(del){
        axios.delete(`http://localhost:8081/emp/?empId=${empId}`)
        .then(() => setEmployees(employees.filter(emp => emp.empId !== empId)))
        .catch(err=>console.error("delete failed ",err))
        }
    }
    return (
        <>
            <table className="table table-light table-striped-columns w-50">
                <thead>
                    <tr>
                        <th>Emp Id</th>
                        <th>Name</th>
                        <th>View</th>
                        <th>Edit</th>
                        <th>Delete</th>
                    </tr>
                </thead>
                <tbody>
                {
                    employees.map(emp=>(
                        <tr>
                            <td>{emp.empId}</td>
                            <td>{emp.name}</td>
                            <td><button className="btn btn-success"  onClick={()=>handleRowClick(emp.empId)}>view</button></td>
                            <td><button className="btn btn-secondary" onClick={()=>handleEditBtn(emp.empId)}>edit</button></td>
                            <td><button className="btn btn-danger" onClick={()=>handleDelete(emp.empId)}>delete</button></td>
                        </tr>
                    ))
                }
                </tbody>
            </table>
        </>
    )
        
}