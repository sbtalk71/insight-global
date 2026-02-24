package com.demo.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UpdateDemo {
    public static void main(String[] args) {

        String update_sql="update employee set salary=? where empno=?";
        try(
                Connection conn= DriverManager.getConnection("jdbc:mariadb://localhost:3307/training","root","root");
                PreparedStatement pst = conn.prepareStatement(update_sql);
               
                ){

            pst.setDouble(1,56000);
            pst.setInt(2,110);


            int count1=pst.executeUpdate();
            System.out.println("Count is "+count1);
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}
