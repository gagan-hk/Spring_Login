package controller;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Gagandeep.Singh on 1/9/2015.
 */
public class UserRowMapper implements RowMapper {
    public Object mapRow(ResultSet rs , int rownum)
            throws SQLException {
        LoginBean user = new LoginBean();
        user.setName(rs.getString("name"));
        user.setPassword(rs.getString("pwd"));
        return user;
    }
}
