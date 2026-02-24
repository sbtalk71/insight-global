package com.demo.table.hierarchy;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@DiscriminatorValue("T")
@Entity
public class TraineeEmp extends Employee{
    private String performance;

    public TraineeEmp(){

    }

    public TraineeEmp(String name, Integer id, double salary, String performance) {
        super(name, id, salary);
        this.performance = performance;
    }

    public String getPerformance() {
        return performance;
    }

    public void setPerformance(String performance) {
        this.performance = performance;
    }
}
