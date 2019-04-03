package com.lys.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DevtoolsController {

    @RequestMapping("/show")
    public String show(){
        System.out.println("hello....aassss");
        return "hello";
    }
}
