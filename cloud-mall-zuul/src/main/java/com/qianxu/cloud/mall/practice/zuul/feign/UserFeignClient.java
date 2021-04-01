package com.qianxu.cloud.mall.practice.zuul.feign;

import com.qianxu.cloud.mall.practice.user.model.pojo.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @author 谦虚
 * @version 1.0
 * @date 2021/3/29 22:29
 * @describe
 */
@FeignClient(value = "cloud-mall-user")
public interface UserFeignClient {

    /**
     * 校验用户权限
     * @param user 接收校验的用户
     * @return 校验结果
     */
    @PostMapping(value = "/checkAdminRole")
    public Boolean checkAdminRole(@RequestBody User user);
}
