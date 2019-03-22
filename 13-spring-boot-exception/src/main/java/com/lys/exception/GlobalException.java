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
        mappings.put("java.lang.ArithmeticException", "error");
        mappings.put("java.lang.NullPointerException", "error");
        resolver.setExceptionMappings(mappings);
        return resolver;
    }

}
