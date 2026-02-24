package com.demo.jdbc;

import java.sql.*;

public class PstDemo {
    public static void main(String[] args) {
//final String driver="org.mariadb.jdbc.Driver";
        try (
               // Class.forName(driver);

                //get the connection
                Connection conn = DriverManager.getConnection("jdbc:mariadb://localhost:3307/training", "root", "root");

                PreparedStatement pst = conn.prepareStatement("Select name,salary from Employee");


                ResultSet rs = pst.executeQuery();
        ) {

            while (rs.next()) {
                System.out.println(rs.getDouble("salary") + " " + rs.getString("NAME"));

                System.out.println(rs.getString(1) + " " + rs.getDouble(2));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}