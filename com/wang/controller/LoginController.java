package com.wang.controller;

import com.wang.mapper.BlogMapper;
import com.wang.pojo.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class LoginController {
    @Autowired
    BlogMapper blogMapper;
    @RequestMapping("/user/login")
    public String login(@RequestParam("username") String username,
                        @RequestParam("password") String password,
                        Model model,
                        HttpSession session, HttpServletRequest request){
        Admin login = blogMapper.login(username, password);
        if (login!=null){
            session.setAttribute("loginUser",username);
            Object loginUser = request.getSession().getAttribute("loginUser");
            System.out.println("这是Controller的loginUser=======================>");
            System.out.println(loginUser);
            return "redirect:/main.html";
        }else {
            model.addAttribute("msg","账号或者密码错误");
            return "indexLogin";

        }

    }
    @RequestMapping("/user/loginOut")
    public String LoginOut(HttpSession session){
        session.invalidate();
        return "redirect:/root";
    }
}
