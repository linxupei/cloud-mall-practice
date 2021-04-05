package com.qianxu.cloud.mall.practice.categoryproduct.model.pojo;

import lombok.Data;

import java.util.Date;

/**
 * plain ordinary java object
 */
@Data
public class Category {
    private Integer id;

    private String name;

    private Integer type;

    private Integer parentId;

    private Integer orderNum;

    private Date createTime;

    private Date updateTime;
}