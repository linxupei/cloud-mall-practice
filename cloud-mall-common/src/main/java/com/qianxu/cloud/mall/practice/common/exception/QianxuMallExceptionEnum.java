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
     * 数据库添加数据失败
     */
    CREATE_FAILED(10012, "创建失败"),
    /**
     * 数据库删除数据失败
     */
    DELETE_FAILED(10013, "删除失败"),
    /**
     * 创建文件夹失败
     */
    MKDIR_FAILED(10014, "创建文件夹失败"),
    /**
     * 创建文件夹失败
     */
    UPLOAD_FAILED(10015, "上传失败"),
    /**
     * 商品已经下架
     */
    NOT_SALE(10016, "商品不在销售期"),
    /**
     * 商品库存不足
     */
    NOT_ENOUGH(10017, "商品库存不足"),
    /**
     * 购物车为空
     */
    CART_EMPTY(10018, "购物车为空"),
    /**
     * 订单不存在
     */
    NO_ORDER(10019, "订单不存在"),
    /**
     * 非所属订单
     */
    NOT_YOUR_ORDER(10020, "非所属订单"),
    /**
     * 订单状态错误
     */
    WRONG_ORDER_STATUS(10021, "订单状态错误"),
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
