package controller;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Gagandeep.Singh on 1/12/2015.
 */
@RestController
public class DisplayAllController {
    @RequestMapping(value = "/disp_all" , method = RequestMethod.GET)
    @ResponseBody
    public LoginBean ListAll(){
        ApplicationContext ctx=new ClassPathXmlApplicationContext("applicationContext.xml");
        LoginDao dao = (LoginDao)ctx.getBean("ldao");
        //List<LoginBean> users = dao.getAll();
        System.out.print("jkshak");
        LoginBean u = new LoginBean("gagan123" , "12345");
        //return new ResponseEntity<List<UserBean>>(users , HttpStatus.OK);
        return u;
    }
}
