package com.demo.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="EMPLOYEE")
public class Emp {

    @Id
    @Column(name="EMPNO")
    private Integer empId;

    @Column(name="NAME")
    private String empName;

    @Column(name="ADDRESS")
    private String city;

    private double salary;

    @Column(name="DNO")
    private Integer deptNo;

    public Emp() {
    }

    public Emp(Integer empId, String empName, String city, double salary, Integer deptNo) {
        this.empId = empId;
        this.empName = empName;
        this.city = city;
        this.salary = salary;
        this.deptNo = deptNo;
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

    public Integer getDeptNo() {
        return deptNo;
    }

    public void setDeptNo(Integer deptNo) {
        this.deptNo = deptNo;
    }
}
