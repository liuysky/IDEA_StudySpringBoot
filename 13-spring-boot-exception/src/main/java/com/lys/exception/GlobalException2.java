package com.lys.exception;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class GlobalException2 implements HandlerExceptionResolver {
    @Override
    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception e) {
        ModelAndView mv=new ModelAndView();
        if(e instanceof ArithmeticException){
            mv.setViewName("error");
        }
        if (e instanceof NullPointerException){
            mv.setViewName("error");
        }
        mv.addObject("error",e.toString());
        return mv;
    }
}
