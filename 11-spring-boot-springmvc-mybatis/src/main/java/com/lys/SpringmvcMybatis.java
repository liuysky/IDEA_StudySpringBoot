package com.lys;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.lys.mapper")
public class SpringmvcMybatis {
    public static void main(String[] args) {

        SpringApplication.run(SpringmvcMybatis.class,args);
        System.out.println("启动成功");
    }
}
