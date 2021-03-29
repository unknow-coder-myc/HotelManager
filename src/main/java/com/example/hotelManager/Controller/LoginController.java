package com.example.hotelManager.Controller;

import com.example.hotelManager.Service.ManagerService;
import com.example.hotelManager.pojo.Manager;
import com.example.hotelManager.Result.Result;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpSession;

/*
* code 400响应成功 200响应失败
* */
@Controller
public class LoginController {
   @Autowired
   ManagerService managerService;


    @CrossOrigin
    @RequestMapping(value="api/login")
    @ResponseBody
    public Result login(@RequestBody  Manager requestManager,HttpSession session) {
    String ManagerID = requestManager.getManagerID();
    String ManagerPassword = requestManager.getManagerPassword();
    System.out.println("ManagerID:"+ManagerID+"\nManagerPassword:"+ManagerPassword);

    Manager manager = managerService.login(ManagerID,ManagerPassword);
    System.out.println("对象:"+manager);
   if(manager==null)
        {
            String message ="账号密码错误";
            System.out.println("test");
            return new Result(400);
        }
        else{
            session.setMaxInactiveInterval(30);
            session.setAttribute("manager",manager);
            System.out.println(session.getId());
            System.out.println("SessionName:"+session.getAttribute("manager"));

            return new Result(true,200,"登录成功",manager.getManagerID());
        }
    }

    }

