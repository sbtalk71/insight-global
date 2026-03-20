import { BrowserRouter, Route, Routes } from "react-router-dom";
import { Home } from "../pages/Home";
import { EditEmployee } from "../pages/EditEmployee";
import { AddEmployee } from "../pages/AddEmployee";
import { Employees } from "../pages/Employees";
import { EmployeeDetails } from "../pages/EmployeeDetails";

export function NavBar() {
    return (
        <BrowserRouter>
            <Routes>
                <Route path="/" element={<Home />} />
                <Route path="addEmployee" element={<AddEmployee />} />
                <Route path="editEmployee" element={<EditEmployee />} />
                <Route path="employees" element={<Employees />} />
                <Route path="employees/:id" element={<EmployeeDetails/>}/>
            </Routes>
        </BrowserRouter>
    );
}