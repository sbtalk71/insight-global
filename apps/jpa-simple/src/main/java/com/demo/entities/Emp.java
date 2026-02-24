package com.demo.entities;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

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

    @Embedded
    Address address;

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name="emp_images")
    private Set<String> images=new HashSet<>();


    public Address getAddress() {
        return address;
    }

    public Set<String> getImages() {
        return images;
    }

    public void setImages(Set<String> images) {
        this.images = images;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

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
