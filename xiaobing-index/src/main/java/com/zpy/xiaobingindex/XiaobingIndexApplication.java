package com.zpy.xiaobingindex;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@MapperScan("com.zpy.xiaobingindex.mapper") //扫描的mapper
@EnableCaching
public class XiaobingIndexApplication {

    public static void main(String[] args) {
        SpringApplication.run(XiaobingIndexApplication.class, args);
    }

}
