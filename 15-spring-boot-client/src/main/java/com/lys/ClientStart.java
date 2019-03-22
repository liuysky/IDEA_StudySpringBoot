package com.lys;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ClientStart {

    private final static Logger logger=LoggerFactory.getLogger(ClientStart.class);
    public static void main(String[] args) {
        SpringApplication.run(ClientStart.class,args);
       logger.info("启动成功");
    }
}
