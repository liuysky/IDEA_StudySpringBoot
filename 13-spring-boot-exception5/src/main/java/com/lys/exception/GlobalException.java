package com.lys.exception;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Properties;

@Configuration
public class GlobalException implements HandlerExceptionResolver {


    @Override
    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception e) {
        ModelAndView mv=new ModelAndView();
        if (e instanceof ArithmeticException){
            mv.setViewName("error1");
        }

        if (e instanceof NullPointerException){
            mv.setViewName("error2");
        }
        mv.addObject("error",e.toString());
        return  mv;
    }
}
