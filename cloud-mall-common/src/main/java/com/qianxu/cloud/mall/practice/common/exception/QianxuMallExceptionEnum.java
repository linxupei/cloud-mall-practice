package com.qianxu.cloud.mall.practice.common.exception;

/**
 * @author 谦虚
 * @version 1.0
 * @date 2021/3/6 16:15
 * @describe 异常枚举
 */
public enum QianxuMallExceptionEnum {
    /**
     * 参数错误
     */
    REQUEST_PARAM_ERROR(10001, "参数有误, 请重试"),
    /**
     * 找不到枚举
     */
    NOT_ENUM(10002, "找不到枚举"),
    /**
     * 用户注册或登录需要提供用户名
     */
    NEED_USER_NAME(10003, "需要用户名"),
    /**
     * 用户注册或登录需要提供密码
     */
    NEED_PASSWORD(10004, "需要用户名"),
    /**
     * 密码应该大于等于8位
     */
    PASSWORD_TOO_SHORT(10005, "密码不能过短"),
    /**
     * 数据库中已存在该用名
     */
    NAME_EXISTED(10006, "已存在该用户名"),
    /**
     * 向数据库插入数据失败
     */
    INSERT_FAILED(10007, "插入失败"),
    /**
     * 密码与数据库中用户密码不匹配
     */
    WRONG_PASSWORD(10008, "密码错误"),
    /**
     * 向数据库更新数据失败
     */
    UPDATE_FAILED(10009, "更新失败"),
    /**
     * 用户未登录
     */
    NEED_LOGIN(10010, "需要登录"),
    /**
     * 该用户不具有管理员权限
     */
    NEED_ADMIN(10011, "需要管理员权限"),
    /**
     * 系统错误
     */
    SYSTEM_ERROR(20000, "系统异常");

    /**
     * 异常码
     */
    private Integer code;

    /**
     * 异常信息
     */
    private String msg;

    QianxuMallExceptionEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
