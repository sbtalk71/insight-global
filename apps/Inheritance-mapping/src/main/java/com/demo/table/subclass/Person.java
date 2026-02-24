package com.demo.table.subclass;

import jakarta.persistence.*;

@Entity(name = "person1")
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "PERSON")
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
