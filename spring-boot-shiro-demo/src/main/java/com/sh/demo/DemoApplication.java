package com.sh.demo;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
@MapperScan(basePackages = {"com.sh.demo.core.dao"}) //扫描DAO
public class DemoApplication {

    public static void main(String[] args) {
        ApplicationContext app = SpringApplication.run(DemoApplication.class, args);
    }
}
