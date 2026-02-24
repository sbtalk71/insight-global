package com.demo.table.concrete;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;


@Entity(name="emp1")
@Table(name="EMP1")
public class Employee extends Person {
    private double salary;

   public  Employee(){

    }

    public Employee(String name, Integer id, double salary) {
        super(name, id);
        this.salary = salary;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

}
