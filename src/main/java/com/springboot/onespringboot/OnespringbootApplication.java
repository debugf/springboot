package com.springboot.onespringboot;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.springboot.onespringboot.mapper")
@SpringBootApplication
public class OnespringbootApplication {

    public static void main(String[] args) {
        SpringApplication.run(OnespringbootApplication.class, args);
    }

}
