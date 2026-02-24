package com.demo.ex1;

import java.util.Objects;

public class Emp  implements Comparable<Emp>{
    private int id;
    private String name;
    private String location;
    private double salary;

    public Emp() {
    }

    public Emp(int id, String name, String location, double salary) {
        this.id = id;
        this.name = name;
        this.location = location;
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public boolean equals(Object o) {
        System.out.println("equals called...");
        if (o == null || getClass() != o.getClass()) return false;
        Emp emp = (Emp) o;
        return id == emp.id;
    }

    @Override
    public int hashCode() {
        System.out.println("hascode() .. called");
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return "["+id+" "+name+" "+location+" "+salary+"]";
    }

    @Override
    public int compareTo(Emp o) {
        return o.getName().compareTo(this.name);
    }
}
