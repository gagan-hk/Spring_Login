package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Gagandeep.Singh on 1/8/2015.
 */
@Controller
public class LoginController {
    @RequestMapping("/login")
    public ModelAndView login(HttpServletRequest request , HttpServletResponse response){
        String user = request.getParameter("user");
        String pwd = request.getParameter("pwd");
        System.out.print("hello");

        boolean status=true;

        if(status) {
            String s = "Welcome "+user ;
            return new ModelAndView("login-success" , "message" ,s);
        }else {
            return new ModelAndView("login-error" , "message" , "Invalid ID or Password");
        }
    }
}
