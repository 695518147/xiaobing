package com.zpy.xiaobingservice;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@MapperScan("com.zpy.xiaobingservice.mapper") //扫描的mapper
@EnableCaching
public class XiaobingServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(XiaobingServiceApplication.class, args);
    }

}
