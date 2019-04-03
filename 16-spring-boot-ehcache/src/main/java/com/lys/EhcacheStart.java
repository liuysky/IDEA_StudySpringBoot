package com.lys;

import net.sf.ehcache.Ehcache;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class EhcacheStart {
    public static void main(String[] args) {
        SpringApplication.run(Ehcache.class,args);
    }
}
