package com.lys.controller;

import com.lys.pojo.Users;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

@Controller
public class DemoController {
    @RequestMapping("/show")
    public String show(Model model,Integer id,String name){
        System.out.println(name);
        System.out.println(id);
        model.addAttribute("msg","Thymeleaf");
        model.addAttribute("date",new Date());
        return "index";
    }
    @RequestMapping("/show2")
    public String show2(Model model){
        model.addAttribute("sex","女");
        model.addAttribute("id",3);
        return "index2";
    }

    @RequestMapping("/show3")
    public String show3(Model model){
        List<Users> list=new ArrayList<>();
        list.add(new Users(1,"张三",20));
        list.add(new Users(2,"李四",21));
        list.add(new Users(3,"王五",22));
        model.addAttribute("list",list);

        return "index3";
    }

    @RequestMapping("/show4")
    public String show4(Model model){
        Map<String,Users> map=new HashMap();
        map.put("u1",new Users(1,"张三",20));
        map.put("u2",new Users(2,"李四",21));
        map.put("u3",new Users(3,"王五",22));
        model.addAttribute("map",map);
        return "index4";
    }

    @RequestMapping("/show5")
    public String show5(HttpServletRequest request,Model model){
        request.setAttribute("req","HttpServletRequest");
        request.getSession().setAttribute("session","HttpSession");
        request.getSession().getServletContext().setAttribute("context","ServletContext");
        return "index5";
    }

    @RequestMapping("/{page}")
    public String url(@PathVariable String page){

        return page;
    }


















}
