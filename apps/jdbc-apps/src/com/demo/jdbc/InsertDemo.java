package com.demo.jdbc;

import javax.xml.transform.stream.StreamSource;
import java.sql.*;

public class InsertDemo {
    public static void main(String[] args) {

        String insert_sql="insert into employee(empno,name,address,salary,dno) values (?,?,?,?,?)";
        try(
                Connection conn= DriverManager.getConnection("jdbc:mariadb://localhost:3307/training","root","root");
                PreparedStatement pst = conn.prepareStatement(insert_sql);

                ){

            pst.setInt(1,110);
            pst.setString(2,"Satish");
            pst.setString(3,"Bangalore");
            pst.setDouble(4,87000);
            pst.setInt(5,20);
            int count=pst.executeUpdate();

            System.out.println("Rows Inserted : "+count);

            pst.setInt(1,111);
            pst.setString(2,"Kishan");
            pst.setString(3,"Hyderabad");
            pst.setDouble(4,70000);
            pst.setInt(5,10);

            int count1=pst.executeUpdate();
            System.out.println("Count is "+count1);
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}
