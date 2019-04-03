package com.lys.exception;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;

import java.util.Properties;

@Configuration
public class GlobalException {

    @Bean
    public SimpleMappingExceptionResolver getSimpleMappingExceptionResolver(){
        SimpleMappingExceptionResolver resolver=new SimpleMappingExceptionResolver();
        Properties mappings=new Properties();
        //参数一：异常的类型，注意必须是异常类型的全名
        //参数二：视图名
        mappings.put("java.lang.ArithmeticException.class","error1");
        mappings.put("java.lang.NullPointerException.class","error2");
        resolver.setExceptionMappings(mappings);
        return resolver;
    }

}
