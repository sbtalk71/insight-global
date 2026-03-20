import { useEffect, useState } from "react";
import "bootstrap/dist/css/bootstrap.min.css";
import { useNavigate, useParams } from "react-router-dom";
import axios from "axios";

export function EmployeeForm() {

    const [employee, setEmployee] = useState({ empId: 0, name: "", city: "", salary: 0, deptNo: 0 });

    const { id } = useParams();
    const navigate=useNavigate();

    if (id) {
        useEffect(() => {
            axios.get(`http://localhost:8081/emp/${id}`)
                .then(response => setEmployee(response.data))
                .catch(err => console.log(err));
        }, [id]);
    }

    const handleChange = (event) => {
        setEmployee({ ...employee, [event.target.name]: event.target.value });

    }

    const handleSubmit = (event) => {
        event.preventDefault();
       const apiResponse= 
       id?axios.put("http://localhost:8081/emp/",employee)
       :axios.post("http://localhost:8081/emp/",employee);
       apiResponse.then(resp=>{setEmployee(resp.data);navigate("/")}).catch(err=>console.log(err));
    }
    return (
        <>

            <div className="container-fluid mt-5 w-50" >
                <h2>{id ? 'Edit' : 'Add'} Employee</h2>
                <form onSubmit={handleSubmit}>
                    <div className="mb-3 text-start">
                        <label className="form-label" >Employee Id</label>
                        <input className="form-control" type="text" id="empId" name="empId" onChange={handleChange} value={employee.empId} />
                    </div>
                    <div className="mb-3 text-start">
                        <label className="form-label">Employee Name</label>
                        <input className="form-control" type="text" id="name" name="name" onChange={handleChange} value={employee.name} />
                    </div>
                    <div className="mb-3 text-start">
                        <label className="form-label">Location</label>
                        <input className="form-control" type="text" id="city" name="city" onChange={handleChange} value={employee.city} />
                    </div>
                    <div className="mb-3 text-start">
                        <label className="form-label">Salary</label>
                        <input className="form-control" type="text" id="salary" name="salary" onChange={handleChange} value={employee.salary} />
                    </div>
                    <div className="mb-3 text-start">
                        <label className="form-label">Dept Number</label>
                        <input className="form-control" type="text" id="deptNo" name="deptNo" onChange={handleChange} value={employee.deptNo} />
                    </div>
                    <button type="submit" className="btn btn-primary">Submit</button>
                </form>
            </div>
        </>
    );
}