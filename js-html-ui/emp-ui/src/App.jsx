import { BrowserRouter, Route, Routes } from 'react-router-dom';
import './App.css'
import NavBar  from './components/NavBar';
import { EmployeeDetails } from './pages/EmployeeDetails';
import {Home} from './pages/Home'
import { Employees } from './pages/Employees';
import { AddEmployee } from './pages/AddEmployee';
import { EditEmployee } from './pages/EditEmployee';
import ErrorPage from './pages/ErrorPage';



function App() {
  return (
    <>
     <BrowserRouter>
     <NavBar/>
            <Routes>
                <Route path="/" element={<Home />} />
                <Route path="addEmployee" element={<AddEmployee />} />
                <Route path="editEmployee/:id" element={<EditEmployee />} />
                <Route path="employees" element={<Employees />} />
                <Route path="employees/:id" element={<EmployeeDetails/>}/>
                <Route path="error" element={<ErrorPage/>}/>
            </Routes>
        </BrowserRouter>
    </>
  );
}

export default App
