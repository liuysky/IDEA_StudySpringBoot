package com.lys.controller;

import com.lys.pojo.Users;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
public class UsersController {
    @RequestMapping("/addUser")
    public String addUser(Users users) {

        return "addUser";
    }

    /**
     * @Valid 开启对Users对象的数据校验
     * BindingResult:封装了校验的结果
     *
     */
    @RequestMapping("/save")
    public String saveUser(@Valid Users users, BindingResult result) {
        if(result.hasErrors()){
            return "addUser";
        }
        System.out.println(users);
        return "ok";
    }
}
