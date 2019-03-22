package com.lys.controller;

import com.lys.pojo.Users;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ClientController {
    @RequestMapping(value = "/doGet/{id}",method = RequestMethod.GET)
    public String doGet(@PathVariable Integer id){
        System.out.println("doGet..."+id);
        return "ok";
    }
    @RequestMapping(value = "/doPost",method = RequestMethod.POST)
    public String doPost(Users users){
        System.out.println(users);
        return "ok";
    }
}
