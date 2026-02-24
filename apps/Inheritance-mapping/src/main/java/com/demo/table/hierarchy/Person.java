package com.demo.table.hierarchy;

import jakarta.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Table(name = "INHERITANCE")
@DiscriminatorColumn(name="PERSONTYPE")
@DiscriminatorValue("P")
public class Person {
    @Id
    private Integer id;
    private String name;

    public Person(){}

    public Person(String name, Integer id) {
        this.name = name;
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
