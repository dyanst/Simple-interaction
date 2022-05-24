package com.wang.controller;

import com.wang.mapper.BlogMapper;
import com.wang.pojo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;


@Controller
public class BlogController {
    @Autowired
    private BlogMapper blogMapper;
    @RequestMapping("/")
    public String queryBlog(Model model){
        List<Blog> blogs = blogMapper.queryBlog();
        List<Blogul> bloguls = blogMapper.queryBlogul();
        List<Friend> friends = blogMapper.queryFriend();
        Person personById = blogMapper.getPersonById(1);
        model.addAttribute("msg",blogs);
        model.addAttribute("ul",bloguls);
        model.addAttribute("frs",friends);
        model.addAttribute("per",personById);
        return "index";
    }
    @RequestMapping("/person")
    public String getPersonAll(Model model){
        List<Person> person = blogMapper.queryPerson();
        model.addAttribute("msg",person);

        return "Bem/Display-page/indexadmin-person";
    }
    @RequestMapping("/person/{id}")
    public String toupdatePerson(@PathVariable("id") int id, Model model){
        Person personById = blogMapper.getPersonById(id);
        model.addAttribute("personById",personById);
        return "Bem/Function-page/indexadmin-person-update";
    }
    @RequestMapping("/updatePer")
    public String updatePerson(Person person){
            blogMapper.updatePerson(person);
        return "redirect:person";
    }
    //账号密码
    @RequestMapping("/updRoot")
    public String updateAdmin(@RequestParam("username") String username,
                              @RequestParam("password1") String password1,
                              @RequestParam("password2") String password2,
                              Model model,
                              Admin admin){
        if (!StringUtils.isEmpty(username)&&password1.equals(password2)){
            blogMapper.updateAdmin(new Admin(1,username,password1));
            System.out.println("成功");
        }else {
            System.out.println("失败");
        }

        return "redirect:pss.html";
    }

    //友人
    @RequestMapping("/blog")
    public String getBlogAll(Model model){
        List<Blog> blogs = blogMapper.queryBlog();
        model.addAttribute("blogs",blogs);
        return "Bem/Display-page/indexadmin-blog";
    }
    @RequestMapping("/blog/{id}")
    public String toupdateBlog(@PathVariable("id") int id, Model model){
        Blog userById = blogMapper.getUserById(id);
        model.addAttribute("userById",userById);
        return "Bem/Function-page/indexadmin-blog-update";
    }
    @RequestMapping("/updateBlog")
    public String updateBlog(Blog Blog){
        blogMapper.updateBlog(Blog);
        return "redirect:blog";
    }
    @RequestMapping("/deleteBlog/{id}")
    public String deleteBlog(@PathVariable("id") int id){
        blogMapper.deleteBlog(id);
        return "redirect:blog";
    }
    @RequestMapping("/addBlog")
    public String addBlog(Blog blog){
        blogMapper.addBlog(blog);
        return "redirect:blog";
    }

    @RequestMapping("/friend")
    public String getFriendAll(Model model){
        List<Friend> friends = blogMapper.queryFriend();
        model.addAttribute("friends",friends);

        return "Bem/Display-page/indexadmin-friend";
    }
    @RequestMapping("/addFriend")
    public String addFriend(Friend friend){
        blogMapper.addFriend(friend);
        return "redirect:friend";
    }
    @RequestMapping("/deleteFriend/{id}")
    public String deleteFriend(@PathVariable("id") int id){
        blogMapper.deleteFriend(id);
        return "redirect:friend";
    }





}
