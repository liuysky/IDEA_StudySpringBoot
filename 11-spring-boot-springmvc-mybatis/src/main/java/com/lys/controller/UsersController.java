package com.lys.controller;

import com.lys.pojo.Users;
import com.lys.service.UsersService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping("/users")
public class UsersController {
    @Resource
    private UsersService usersService;

    @RequestMapping("/{page}")
    public String showPage(@PathVariable String page){
        return page;
    }

    @RequestMapping("/addUser")
    public String addUser(Users users){
        this.usersService.addUser(users);
        return "redirect:/users/findUserAll";
    }

    @RequestMapping("/findUserAll")
    public String findUserAll(Model model){
        List<Users> list = this.usersService.findUserAll();
        model.addAttribute("list",list);
        return "showUsers";
    }

    @RequestMapping("/findUserById")
    public String findUserById(Integer id,Model model){
        Users user = this.usersService.findUserById(id);
        model.addAttribute("user",user);
        return "updateUser";
    }
    @RequestMapping("/editUser")
    public String updateUser(Users user){
        this.usersService.updateUser(user);
        return "redirect:/users/findUserAll";
    }

    @RequestMapping("/deleteUserById")
    public String deleteUserById(Integer id){
        this.usersService.deleteUserById(id);
        return "redirect:/users/findUserAll";
    }
}
