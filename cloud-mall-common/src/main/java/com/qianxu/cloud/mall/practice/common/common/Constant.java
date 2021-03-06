package com.qianxu.cloud.mall.practice.common.common;

import com.google.common.collect.Sets;
import com.qianxu.cloud.mall.practice.common.exception.QianxuMallException;
import com.qianxu.cloud.mall.practice.common.exception.QianxuMallExceptionEnum;
import org.springframework.stereotype.Component;

import java.util.Set;

/**
 * @author 谦虚
 * @version 1.0
 * @date 2021/3/6 19:54
 * @describe
 */
@Component
public class Constant {
    public static final String QIANXU_MALL_USER = "qianxu_mall_user";

    public static final String SALT = "1/da1@&^s7fy2.,,opfkgs[;";

    public interface ProductListOrderBy {
        Set<String> PRICE_ASC_DESC = Sets.newHashSet("price desc", "price asc");
    }

    public interface SaleStatus {
        //商品上架状态
        int SALE = 1;
        //商品下架状态
        int NOT_SALE = 0;
    }

    public interface CheckStatus {
        //商品选中状态
        int CHECKED = 1;
        //商品未选中状态
        int UN_CHECKED = 0;
    }

    public enum OrderStatusEnum {
        /**
         * 订单状态：已取消
         */
        CANCELED(0, "用户已取消"),
        /**
         * 订单状态：未付款
         */
        NOT_PAID(10, "未付款"),
        /**
         * 订单状态：已付款
         */
        PAID(20, "已付款"),
        /**
         * 订单状态：已发货
         */
        DELIVERED(30, "已发货"),
        /**
         * 订单状态：交易完成
         */
        FINISHED(40, "交易完成");

        private Integer code;
        private String value;

        public static OrderStatusEnum codeOf(Integer code) {
            for (OrderStatusEnum orderStatusEnum : values()) {
                if (orderStatusEnum.getCode().equals(code)) {
                    return orderStatusEnum;
                }
            }
            throw new QianxuMallException(QianxuMallExceptionEnum.NOT_ENUM);
        }

        OrderStatusEnum(Integer code, String value) {
            this.code = code;
            this.value = value;
        }

        public Integer getCode() {
            return code;
        }

        public void setCode(Integer code) {
            this.code = code;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }
    }
}
