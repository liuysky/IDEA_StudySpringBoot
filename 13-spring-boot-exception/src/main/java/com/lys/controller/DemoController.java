package com.lys.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class DemoController {
    @RequestMapping("/show")
    public String showInfo(){
        String str=null;
        str.length();
        return "index";
    }

    @RequestMapping("/show2")
    public String showInfo2(){
        int a=10/0;
        return "index";
    }

    @ExceptionHandler(value = {java.lang.ArithmeticException.class})
    public ModelAndView arithmeticExceptionHandler(Exception e){
        ModelAndView mv=new ModelAndView();
        mv.addObject("error",e.toString());
        mv.setViewName("error");
        return mv;
    }

    @ExceptionHandler(value = {java.lang.NullPointerException.class})
    public ModelAndView nullPointExceptionHandler(Exception e){
        ModelAndView mv=new ModelAndView();
        mv.addObject("error",e.toString());
        mv.setViewName("error");
        return mv;
    }
}
