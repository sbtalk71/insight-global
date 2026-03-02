package com.demo.spring.runners;

import com.demo.spring.entity.Emp;
import org.springframework.boot.CommandLineRunner;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

//@Component
public class InsertRunner implements CommandLineRunner {
    private JdbcTemplate jdbcTemplate;

    public InsertRunner(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void run(String... args) throws Exception {

        int count=jdbcTemplate.update(new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
                PreparedStatement pst=
                        con.prepareStatement("insert into employee(empno,name,address,salary,dno) " +
                                "values(?,?,?,?,?)");
                pst.setInt(1,400);
                pst.setString(2,"Lokesh");
                pst.setString(3,"Indore");
                pst.setDouble(4,56000);
                pst.setInt(5,20);
                return pst;
            }
        });
        System.out.println("Rows updated : "+count);
    }
}
