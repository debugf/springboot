package com.springboot.springbootmybatisplus;

import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.springboot.springbootmybatisplus.mapper")
public class SpringbootMybatisplusApplication {

    private static final Logger logger = LoggerFactory.getLogger(SpringbootMybatisplusApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(SpringbootMybatisplusApplication.class, args);
        logger.info("========================启动完毕========================");
    }

}
