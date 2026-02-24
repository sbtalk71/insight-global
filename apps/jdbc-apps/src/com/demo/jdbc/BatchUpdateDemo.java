package com.demo.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class BatchUpdateDemo {
    public static void main(String[] args) {

        String insert_sql = "insert into employee(empno,name,address,salary,dno) values (?,?,?,?,?)";
        try (
                Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3307/training", "root", "root");
                PreparedStatement pst = conn.prepareStatement(insert_sql);

        ) {



            pst.setInt(1, 110);
            pst.setString(2, "Satish");
            pst.setString(3, "Bangalore");
            pst.setDouble(4, 87000);
            pst.setInt(5, 20);
            pst.addBatch();


            pst.setInt(1, 111);
            pst.setString(2, "Kishan");
            pst.setString(3, "Hyderabad");
            pst.setDouble(4, 70000);
            pst.setInt(5, 10);
            pst.addBatch();

            pst.setInt(1, 102);
            pst.setString(2, "Kiran");
            pst.setString(3, "Hyderabad");
            pst.setDouble(4, 57000);
            pst.setInt(5, 30);
            pst.addBatch();

            conn.setAutoCommit(false);
            try {
                pst.executeBatch();

                conn.commit();
            } catch (SQLException e) {
                conn.rollback();
                conn.setAutoCommit(true);
                e.printStackTrace();
            }

        } catch (SQLException e) {

            e.printStackTrace();
        }
    }
}
