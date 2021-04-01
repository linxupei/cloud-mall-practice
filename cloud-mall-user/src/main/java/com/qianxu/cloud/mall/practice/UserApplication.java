package com.qianxu.cloud.mall.practice;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author 谦虚
 * @version 1.0
 * @date 2021/3/29 17:23
 * @describe
 */
@SpringBootApplication
@EnableSwagger2
@MapperScan(basePackages = "com.qianxu.cloud.mall.practice.user.model.dao")
@EnableRedisHttpSession
public class UserApplication {

    public static void main(String[] args) {
        SpringApplication.run(UserApplication.class, args);
    }
}
