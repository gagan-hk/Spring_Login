package controller;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by Gagandeep.Singh on 1/12/2015.
 */
@RestController
public class DisplayAllController {
    @RequestMapping(value ="/users", produces="application/json")
    public @ResponseBody
    List<LoginBean> ListUser(){
        ApplicationContext ctx=new ClassPathXmlApplicationContext("applicationContext.xml");
        LoginDao dao = (LoginDao)ctx.getBean("ldao");
        return dao.getAll();
    }
}
