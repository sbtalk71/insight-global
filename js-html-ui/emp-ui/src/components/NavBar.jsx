import { BrowserRouter, Route, Routes } from "react-router-dom";

// components/Navbar.js
import { Link } from "react-router-dom";

function NavBar() {
  return (
    <nav className="navbar navbar-expand-lg navbar-dark bg-dark">
      <div className="container-fluid">
        <Link className="navbar-brand" to="/">Emp App</Link>

        <button 
          className="navbar-toggler" 
          type="button" 
          data-bs-toggle="collapse" 
          data-bs-target="#navbarNav"
        >
          <span className="navbar-toggler-icon"></span>
        </button>

        <div className="collapse navbar-collapse" id="navbarNav">
          <ul className="navbar-nav ms-auto">
            
            <li className="nav-item">
              <Link className="nav-link" to="/">Home</Link>
            </li>

            <li className="nav-item">
              <Link className="nav-link" to="/addEmployee">Add Employee</Link>
            </li>

            <li className="nav-item">
              <Link className="nav-link" to="/employees">Employee List</Link>
            </li>

          </ul>
        </div>
      </div>
    </nav>
  );
}

export default NavBar;