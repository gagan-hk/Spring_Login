package controller;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.portlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Gagandeep.Singh on 1/9/2015.
 */
@Controller

public class RegisterController {

    @RequestMapping("/register")
    public ModelAndView register(HttpServletRequest request , HttpServletResponse response){
        String user = request.getParameter("user");
        String pwd = request.getParameter("pwd");

        LoginBean bean = new LoginBean();
        bean.setName(user);
        bean.setPassword(pwd);
        ApplicationContext ctx=new ClassPathXmlApplicationContext("applicationContext.xml");
        LoginDao dao = (LoginDao)ctx.getBean("ldao");
        int status = dao.insertUser(bean);
        System.out.print(status);

        if(status==1){
            System.out.print(status);
            String s = "<h3>Successful Registration</h3><br>Welcome "+user ;
            return new ModelAndView("login-success" , "message" ,s);
        }else {
            String s = "<h3>Username Already Exists</h3>" ;
            return new ModelAndView("reg-error" , "message" , s);
        }

    }
}
