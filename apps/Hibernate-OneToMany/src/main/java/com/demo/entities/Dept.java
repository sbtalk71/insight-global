package com.demo.entities;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="DEPT")
public class Dept {

    @Id
    @Column(name="DNO")
    private Integer deptNo;

    @Column(name="DNAME")
    private String deptName;

    private String manager;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "dept")
   // @JoinColumn(name="DNO")

    private Set<Emp> emps=new HashSet<>();
    public Dept() {
    }

    public Dept(Integer deptNo, String deptName, String manager) {
        this.deptNo = deptNo;
        this.deptName = deptName;
        this.manager = manager;
    }

    public Set<Emp> getEmps() {
        return emps;
    }

    public void setEmps(Set<Emp> emps) {
        this.emps = emps;
    }

    public Integer getDeptNo() {
        return deptNo;
    }

    public void setDeptNo(Integer deptNo) {
        this.deptNo = deptNo;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public String getManager() {
        return manager;
    }

    public void setManager(String manager) {
        this.manager = manager;
    }
}
