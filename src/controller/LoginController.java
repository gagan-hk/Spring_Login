package controller;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
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
       // System.out.print("hello");
        LoginBean bean = new LoginBean();
        bean.setName(user);
        bean.setPassword(pwd);
        //Resource resource=new ClassPathResource("applicationContext.xml");
        //BeanFactory factory=new XmlBeanFactory(resource);

        ApplicationContext ctx=new ClassPathXmlApplicationContext("applicationContext.xml");
        LoginDao dao = (LoginDao)ctx.getBean("ldao");
        boolean status = dao.validateLogin(bean);
        System.out.print(status);

        if(status) {
            String s = "Welcome "+user ;
            return new ModelAndView("login-success" , "message" ,s);
        }else {
            //System.out.print();
            return new ModelAndView("login-error" , "message" , "Invalid ID or Password");
        }
    }
}
