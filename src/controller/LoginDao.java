package controller;

import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;


/**
 * Created by Gagandeep.Singh on 1/8/2015.
 */
public class LoginDao {
    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public int insertUser(LoginBean e){
        String query = "Select * from USERS where name='"+e.getName()+"'";
        List<LoginBean> userList = jdbcTemplate.query(query , new UserRowMapper());
        if(!userList.isEmpty()) return -1;

        query="insert into users values('"+e.getName()+"','"+e.getPassword()+"')";
        return jdbcTemplate.update(query);
    }

    public boolean validateLogin(LoginBean e) {
        String query = "Select * from USERS where name='"+e.getName()+"' AND pwd='"+e.getPassword()+"'";
        List<LoginBean> userList = jdbcTemplate.query(query , new UserRowMapper());
        if(userList.isEmpty()) return false;
        else return true;
    }
}
