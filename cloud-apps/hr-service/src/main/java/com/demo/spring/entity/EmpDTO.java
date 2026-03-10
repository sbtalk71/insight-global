package com.demo.spring.entity;


public class EmpDTO {

    private Integer empId;

    private String name;


    private String city;

    private Double salary;

    private Integer deptNo;

    public EmpDTO(){}

    public EmpDTO(Integer empId, String name, String city, Double salary, Integer deptNo) {
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

    @Override
    public String toString() {
        return empId+" "+name+" "+salary+" "+city+" "+deptNo;
    }
}
