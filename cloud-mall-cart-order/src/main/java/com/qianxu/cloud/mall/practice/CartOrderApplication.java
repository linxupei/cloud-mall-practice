package com.qianxu.cloud.mall.practice;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

/**
 * @author 谦虚
 * @version 1.0
 * @date 2021/4/1 21:48
 * @describe
 */
@SpringBootApplication
@MapperScan(basePackages = "com.qianxu.cloud.mall.practice.cartorder.model.dao")
@EnableRedisHttpSession
@EnableFeignClients
public class CartOrderApplication {

    public static void main(String[] args) {
        SpringApplication.run(CartOrderApplication.class, args);
    }
}
