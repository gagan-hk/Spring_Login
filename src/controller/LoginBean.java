package controller;

/**
 * Created by Gagandeep.Singh on 1/7/2015.
 */
public class LoginBean {
    private String name,password;
    private String role;
    public LoginBean(){}
    public LoginBean(String name , String password) {
        this.name = name;
        this.password = password;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
}