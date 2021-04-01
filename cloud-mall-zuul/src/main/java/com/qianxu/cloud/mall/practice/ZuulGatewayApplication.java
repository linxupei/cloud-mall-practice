package com.qianxu.cloud.mall.practice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

/**
 * @author 谦虚
 * @version 1.0
 * @date 2021/3/29 22:37
 * @describe
 */
@EnableZuulProxy
@EnableFeignClients
@SpringBootApplication
@EnableRedisHttpSession
public class ZuulGatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(ZuulGatewayApplication.class, args);
    }
}
