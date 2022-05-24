package com.wang.config;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class LoginHandlerInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //登录成功之后，应该有用户的session
        Object loginUser = request.getSession().getAttribute("loginUser");
        System.out.println("这是Config的loginUser======================》");
        System.out.println(loginUser);
        if (loginUser == null) {
            //没有登录，而是直接进入的首页，肯定是不让进的
            request.setAttribute("msg", "没有权限，请先登录");
            request.getRequestDispatcher("/root").forward(request, response);
            return false;
        } else {
            return true;
        }

    }

}
