package com.qianxu.cloud.mall.practice.cartorder.feign;

import com.qianxu.cloud.mall.practice.user.model.pojo.User;
import io.swagger.annotations.ApiOperation;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author 谦虚
 * @version 1.0
 * @date 2021/4/1 22:20
 * @describe UserFeignClient 客户端
 */
@FeignClient(value = "cloud-mall-user")
public interface UserFeignClient {

    /**
     * 在网关已经设置了判空
     * 获取当前用户
     * @return 当前用户
     */
    @ApiOperation("获取当前用户")
    @GetMapping(value = "/getUser")
    @ResponseBody
    public User getUser();
}
