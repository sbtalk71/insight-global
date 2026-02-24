package com.demo.entities;

import jakarta.persistence.*;

@NamedQueries(
        {@NamedQuery(name = "query1", query = "select e from Emp e where e.city=?1"),
                @NamedQuery(name = "query1a", query = "select e from Emp e where e.city=:mycity"),
        @NamedQuery(name="query2",query = "select e.empName,e.salary from Emp e where e.salary>50000"),
        @NamedQuery(name="query3",query = "select new queries.EmpData(e.empName,e.salary) from Emp e where e.salary>50000"),
        @NamedQuery(name="joinquery",query = "select e.empName,e.salary,d.deptName,d.manager from Dept d join d.emps e")}
)
@Entity
@Table(name = "EMPLOYEE")
public class Emp {
    @Id
    @Column(name = "EMPNO")
    private Integer empId;
    @Column(name = "NAME")
    private String empName;
    @Column(name = "ADDRESS")
    private String city;

    private double salary;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "DNO")
    Dept dept;

    public Dept getDept() {
        return dept;
    }

    public void setDept(Dept dept) {
        this.dept = dept;
    }


    public Emp() {
    }

    public Emp(Integer empId, String empName, String city, double salary) {
        this.empId = empId;
        this.empName = empName;
        this.city = city;
        this.salary = salary;
    }

    public Integer getEmpId() {
        return empId;
    }

    public void setEmpId(Integer empId) {
        this.empId = empId;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}
