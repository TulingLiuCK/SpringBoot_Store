package com.lck.springboot_store;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
@MapperScan("com.lck.springboot_store.mapper")  //集中注册mapper
public class SpringBootStoreApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootStoreApplication.class, args);
    }

}
