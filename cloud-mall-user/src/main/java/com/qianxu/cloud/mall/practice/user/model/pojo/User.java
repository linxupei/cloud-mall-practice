package com.qianxu.cloud.mall.practice.user.model.pojo;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author 风
 */

@Data
public class User implements Serializable {
    private Integer id;

    private String username;

    private String password;

    private String personalizedSignature;

    private Integer role;

    private Date createTime;

    private Date updateTime;
}