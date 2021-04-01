package com.cloud.mall.practice;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

/**
 * @author 谦虚
 * @version 1.0
 * @date 2021/4/1 15:14
 * @describe
 */
@SpringBootApplication
@EnableRedisHttpSession
@EnableFeignClients
@MapperScan(basePackages = "com.cloud.mall.practice.categoryproduct.model.dao")
public class CategoryProductApplication {

    public static void main(String[] args) {
        SpringApplication.run(CategoryProductApplication.class, args);
    }
}
