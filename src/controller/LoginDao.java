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

    public boolean insertUser(LoginBean e){
        String query = "Select * from USERS where name='"+e.getName()+"'";
        List<LoginBean> userList = jdbcTemplate.query(query , new UserRowMapper());
        if(!userList.isEmpty())
        return false;

        query="insert into users values('"+e.getName()+"','"+e.getPassword()+"')";
        jdbcTemplate.update(query);
        return true;
    }

    public boolean validateLogin(LoginBean e) {
        String query = "Select * from USERS where name='"+e.getName()+"' AND pwd='"+e.getPassword()+"'";
        List<LoginBean> userList = jdbcTemplate.query(query , new UserRowMapper());
        if(userList.isEmpty()) return false;
        else return true;
    }

    public List<LoginBean> getAll(){
        String query = "Select * from USERS";
        List<LoginBean> userList = jdbcTemplate.query(query , new UserRowMapper());
        return userList;
    }
}
