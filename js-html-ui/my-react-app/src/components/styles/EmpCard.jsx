import "bootstrap/dist/css/bootstrap.min.css"
export function EmpCard() {

    return (
        <div className="card" style={{width: "18rem"}}>
            <div className="card-body">
                <h5 className="card-title">Emp Name</h5>
                <h6 className="card-subtitle mb-2 text-body-secondary">location</h6>
                <p className="card-text">Location</p>
                <p className="card-text">Salary</p>
                <a href="#" className="card-link">back to List</a>
            </div>
        </div>
    );
}