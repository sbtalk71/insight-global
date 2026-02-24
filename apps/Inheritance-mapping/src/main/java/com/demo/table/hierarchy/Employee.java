package com.demo.table.hierarchy;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@DiscriminatorValue("E")
@Entity
public class Employee extends Person{
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
