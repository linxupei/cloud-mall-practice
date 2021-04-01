package com.qianxu.cloud.mall.practice.user.controller;

import com.qianxu.cloud.mall.practice.common.common.ApiRestResponse;
import com.qianxu.cloud.mall.practice.common.common.Constant;
import com.qianxu.cloud.mall.practice.common.exception.QianxuMallException;
import com.qianxu.cloud.mall.practice.common.exception.QianxuMallExceptionEnum;
import com.qianxu.cloud.mall.practice.user.model.pojo.User;
import com.qianxu.cloud.mall.practice.user.service.UserService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

/**
 * @author 谦虚
 * @version 1.0
 * @date 2021/3/5 21:50
 *
 * 用户控制器
 */
@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping({"/personal_page"})
    @ResponseBody
    public User personalPage() {
        return userService.getUser();
    }

    @ApiOperation("用户注册")
    @PostMapping({"/register"})
    @ResponseBody
    public ApiRestResponse register(@RequestParam("userName") String userName,
                                    @RequestParam("password") String password) throws QianxuMallException {
        if (StringUtils.isEmpty(userName)) {
            return ApiRestResponse.error(QianxuMallExceptionEnum.NEED_USER_NAME);
        }
        if (StringUtils.isEmpty(password)) {
            return ApiRestResponse.error(QianxuMallExceptionEnum.NEED_PASSWORD);
        }
        //密码长度不少于8位
        if (password.length() < 8) {
            return ApiRestResponse.error(QianxuMallExceptionEnum.PASSWORD_TOO_SHORT);
        }
        userService.register(userName, password);
        return ApiRestResponse.success();
    }

    @ApiOperation("普通用户登录")
    @PostMapping({"/login"})
    @ResponseBody
    public ApiRestResponse login(@RequestParam("userName") String userName,
                                 @RequestParam("password") String password,
                                 HttpSession session) throws QianxuMallException {
        if (StringUtils.isEmpty(userName)) {
            return ApiRestResponse.error(QianxuMallExceptionEnum.NEED_USER_NAME);
        }
        if (StringUtils.isEmpty(password)) {
            return ApiRestResponse.error(QianxuMallExceptionEnum.NEED_PASSWORD);
        }
        User user = userService.login(userName, password);
        user.setPassword(null);
        session.setAttribute(Constant.QIANXU_MALL_USER, user);
        return ApiRestResponse.success(user);
    }

    @ApiOperation("用户更新签名")
    @PostMapping({"/user/update"})
    @ResponseBody
    public ApiRestResponse updateUserInfo(HttpSession session, @RequestParam String signature) throws QianxuMallException {
        User currentUser = (User) session.getAttribute(Constant.QIANXU_MALL_USER);
        if (currentUser == null) {
            return ApiRestResponse.error(QianxuMallExceptionEnum.NEED_LOGIN);
        }
        User user = new User();
        user.setId(currentUser.getId());
        user.setPersonalizedSignature(signature);
        userService.updateInformation(user);
        return ApiRestResponse.success();
    }

    @ApiOperation("用户注销")
    @PostMapping({"/user/logout"})
    @ResponseBody
    public ApiRestResponse Logout(HttpSession session) {
        session.removeAttribute(Constant.QIANXU_MALL_USER);
        return ApiRestResponse.success();
    }

    @ApiOperation("管理员登录")
    @PostMapping({"/adminLogin"})
    @ResponseBody
    public ApiRestResponse adminLogin(@RequestParam("userName") String userName,
                                 @RequestParam("password") String password,
                                 HttpSession session) throws QianxuMallException {
        if (StringUtils.isEmpty(userName)) {
            return ApiRestResponse.error(QianxuMallExceptionEnum.NEED_USER_NAME);
        }
        if (StringUtils.isEmpty(password)) {
            return ApiRestResponse.error(QianxuMallExceptionEnum.NEED_PASSWORD);
        }
        User user = userService.login(userName, password);
        if (userService.checkAdminRole(user)) {
            user.setPassword(null);
            session.setAttribute(Constant.QIANXU_MALL_USER, user);
        } else {
            return ApiRestResponse.error(QianxuMallExceptionEnum.NEED_ADMIN);
        }
        return ApiRestResponse.success(user);
    }

    /**
     * 校验是否是管理员
     * @param user 校验该用户
     * @return 一个布尔值
     */
    @ApiOperation("校验是否是管理员")
    @GetMapping("/checkAdminRole")
    @ResponseBody
    public Boolean checkAdminRole(@RequestBody User user) {
        return userService.checkAdminRole(user);
    }
}
