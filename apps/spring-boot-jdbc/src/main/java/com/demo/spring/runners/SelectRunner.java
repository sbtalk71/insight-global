package com.demo.spring.runners;

import com.demo.spring.entity.Emp;
import org.springframework.boot.CommandLineRunner;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Component
public class SelectRunner implements CommandLineRunner {
    private JdbcTemplate jdbcTemplate;

    public SelectRunner(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void run(String... args) throws Exception {

    List<Emp> empList= jdbcTemplate.query("Select * from employee", new RowMapper<Emp>() {

            @Override
            public Emp mapRow(ResultSet rs, int rowNum) throws SQLException {
                return new Emp(rs.getInt("EMPNO"),
                        rs.getString("NAME"),
                        rs.getString("ADDRESS"),
                        rs.getDouble("SALARY"),rs.getInt("DNO"));
            }
        });

    empList.forEach(e-> System.out.println(e.getEmpId()+" "+e.getName()+" "+e.getSalary()));
    }
}
