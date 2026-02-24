package com.demo.streams;

import com.demo.Emp;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class EmpStreamsApp {
    public static void main(String[] args) {

        List<Emp> empList = Arrays.asList(
                new Emp(100, "Shantanu", "Hyderabad", 80000),
                new Emp(101, "Pavan", "Pune", 80000),
                new Emp(102, "Ranga", "Hyderabad", 80000),
                new Emp(103, "Kirthi", "Pune", 80000),
                new Emp(104, "Srinivas", "Bangalore", 80000),
                new Emp(105, "Tirumala", "Bangalore", 80000),
                new Emp(106, "Sagar", "Pune", 80000),
                new Emp(107, "Tushar", "Hyderabad", 80000),
                new Emp(108, "Rita", "Chennai", 80000),
                new Emp(109, "Jahangir", "Hyderabad", 80000)
        );

        //List all the employees from Hyderabad

        empList.stream().filter(emp -> emp.getLocation().equals("Hyderabad")).forEach(System.out::println);
        //Transfer Rita to pune with 20000 increment
        empList.stream().filter(emp -> emp.getName().equals("Rita")).map(rita -> {
            rita.setLocation("Pune");
            rita.setSalary(rita.getSalary() + 20000);
            return rita;
        }).forEach(System.out::println);

        //add 2 hobbies to Tirumala with id 105

        empList.stream().filter(emp -> emp.getId() == 105).map(tirumala -> {
            tirumala.setHobbies(Arrays.asList("Singing", "dancing"));
            return tirumala.getHobbies();
        }).forEach(System.out::println);

        //Collect all the employees in hyderabad to a separate Map

       empList.stream()
               .filter(emp->emp.getLocation().equals("Hyderabad"))
               .collect(Collectors.toMap(e->e.getId(), e->e))
               .forEach((x,y)->System.out.println(y));

       //increment salaries of all Pune employees
            empList.stream().filter(emp->emp.getLocation().equals("Pune")).map(emp->{
                emp.setSalary(emp.getSalary()+5000);
                return emp;
            }).forEach(System.out::println);
        // calculate the total salaries of all the employees
        System.out.println(empList.stream().mapToDouble(emp->emp.getSalary()).reduce((x,y)->x+y));

        System.out.println(empList.stream().collect(Collectors.groupingBy(e->e.getLocation())));



    }
}
