package com.demo.spring;

import com.demo.spring.model.Emp;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class EmpRowMapper implements RowMapper<Emp> {
    @Override
    public Emp mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new Emp(rs.getInt("EMPNO"),rs.getString("NAME"),
                rs.getString("ADDRESS"),rs.getDouble("SALARY"));
    }
}
