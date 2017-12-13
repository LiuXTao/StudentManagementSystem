package mypack.controller;


import mypack.Response.Data;
import mypack.serviceImpl.AdministorAccountServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;



@Controller
public class AdministorController {
    @Autowired
    @Qualifier("AdministorAccountServiceImpl")
    private AdministorAccountServiceImpl administorAccountService;


    @RequestMapping("/administor/login")
    @ResponseBody
    public Data login(HttpServletRequest request) {
        String id=request.getParameter("id");
        System.out.println(id);
        String password=request.getParameter("password");
        System.out.println(password);
        Data data=new Data();
        if(administorAccountService.login(Long.parseLong(id), password))
            data.setData(1);
        else
            data.setData(2);
        return data;
    }
}
