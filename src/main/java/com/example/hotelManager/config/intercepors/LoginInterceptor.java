package com.example.hotelManager.config.intercepors;

import com.example.hotelManager.pojo.Manager;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Component
public class LoginInterceptor implements HandlerInterceptor {
    //每次访问接口之前执行的，我们只需要在这里写验证登录状态的业务逻辑，就可以在用户调用接口之前验证登录状态
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response,Object handler) throws Exception{
        //每一个项目对于登录的实现逻辑都有所区别，这里使用最简单的Session提取User来验证登录
        HttpSession session = request.getSession();
        //这里的User是登录时放入Session的
        Manager manager = (Manager) request.getSession();
        //如果session中没有manager,表示没登录
        if(manager == null)
        {
            return false;
        }
        else{
            return true;
        }
    }
}
