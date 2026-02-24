package com.demo.ex1;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class EmpSetDemo {
    public static void main(String[] args) {
        Set<Emp> empList=new HashSet<>();

        empList.add(new Emp(100,"Shantanu","hyderabad",40000));
        empList.add(new Emp(101,"Kiran","bangalore",45000));
        empList.add(new Emp(102,"Pavan","chennai",50000));
        empList.add(new Emp(103,"Shrikanth","hyderabad",60000));
        empList.add(new Emp(104,"Dhoni","bangalore",60000));
        empList.add(new Emp(105,"Tom","pune",40000));
        empList.add(new Emp(106,"Jerry","hyderabad",45000));
        empList.add(new Emp(107,"Sonu","chennai",55000));
        empList.add(new Emp(108,"Govinda","bangalore",50000));
        empList.add(new Emp(109,"Sheela","hyderabad",40000));
        empList.add(new Emp(109,"Sheela","hyderabad",40000));

        System.out.println(empList);

        //search all employees from hyderabad
        for(Emp e:empList){
            if(e.getLocation().equals("hyderabad")){
                System.out.println(e);
            }
        }

        //collect all employees who has salary less than 50000

        // transfer Govinda to Hyderabad with a salary hike of 10000
    }
}
