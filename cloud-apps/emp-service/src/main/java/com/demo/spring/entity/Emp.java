package com.demo.spring.entity;

import jakarta.persistence.*;

@Entity
@Table(name="EMPLOYEE")
public class Emp {
    @Id
    //@GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="EMPNO")
    private Integer empId;

    private String name;

    @Column(name="ADDRESS")
    private String city;

    private Double salary;
    @Column(name="DNO")
    private Integer deptNo;

    public Emp(){}

    public Emp(Integer empId, String name, String city, Double salary, Integer deptNo) {
        this.empId = empId;
        this.name = name;
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

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public Integer getDeptNo() {
        return deptNo;
    }

    public void setDeptNo(Integer deptNo) {
        this.deptNo = deptNo;
    }
}
