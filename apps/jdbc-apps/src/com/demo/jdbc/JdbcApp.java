package com.demo.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class JdbcApp {
    public static void main(String[] args) throws Exception {
        //load the driver
        //Class.forName("org.mariadb.jdbc.Driver");

        //get the connection
       // Connection conn= DriverManager.getConnection("jdbc:mariadb://localhost:3307/training","root","root");
Connection conn=DriverManager.getConnection("jdbc:postgresql://trainingserver.postgres.database.azure.com:5432/postgres","training","welcome@123");
        if(conn!=null){
            System.out.println("Mariadb Connected.....");
            System.out.println(conn.getClass().getName());
        }
       Statement stmt=conn.createStatement();

       ResultSet rs=stmt.executeQuery("Select name,salaryy from Employee");

       while(rs.next()){
           System.out.println(rs.getDouble("salary")+" "+rs.getString("NAME"));

           System.out.println(rs.getString(1)+" "+rs.getDouble(2));
       }


    }
}
