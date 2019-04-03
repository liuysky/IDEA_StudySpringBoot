package com.lys.controller;

import com.lys.pojo.Users;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ClientController {
    @RequestMapping(value = "/doGet/{id}",method = RequestMethod.GET)
    public String doGet(@PathVariable("id") Integer id){
        System.out.println("doGet..."+id);
        return "ok";
    }
    @RequestMapping(value = "/doPost",method = RequestMethod.POST)
    public String doPost(@RequestBody Users users){
        System.out.println(users);
        return "ok";
    }
}
