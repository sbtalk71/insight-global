package com.demo.table.subclass;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;


@Entity(name="emp")
@Table(name="EMP")
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
