package com.demo.spring.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="EMPLOYEE")
public class Emp {
    @Id
    @Column(name="EMPNO")
    private int empId;

    private String name;

    @Column(name="ADDRESS")
    private String city;

    private double salary;
    @Column(name="DNO")
    private int deptNo;

    public Emp(){}

    public Emp(int empId, String name, String city, double salary, int deptNo) {
        this.empId = empId;
        this.name = name;
        this.city = city;
        this.salary = salary;
        this.deptNo = deptNo;
    }

    public int getEmpId() {
        return empId;
    }

    public void setEmpId(int empId) {
        this.empId = empId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public int getDeptNo() {
        return deptNo;
    }

    public void setDeptNo(int deptNo) {
        this.deptNo = deptNo;
    }
}
