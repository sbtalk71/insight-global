package com.demo.table.concrete;

import jakarta.persistence.*;

@Entity(name = "person2")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Table(name = "PERSON1")
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
