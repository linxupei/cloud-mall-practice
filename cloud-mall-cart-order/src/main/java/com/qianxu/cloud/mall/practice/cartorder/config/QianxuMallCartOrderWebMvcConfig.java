package com.qianxu.cloud.mall.practice.cartorder.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author 谦虚
 * @version 1.0
 * @date 2021/4/5 18:00
 * @describe
 */
@Configuration
public class QianxuMallCartOrderWebMvcConfig implements WebMvcConfigurer {

    @Value("${file.upload.dir}")
    private String FILE_UPLOAD_DIR;

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/static/images/**").addResourceLocations("file:" + FILE_UPLOAD_DIR);
    }
}
