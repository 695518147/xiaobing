package com.zpy.xiaobingservice.entity;

import lombok.Data;

import java.util.Date;

@Data
public class User {
    private String userId;

    private String userName;

    private Integer userAge;

    private String email;

    private Date createTime;

    private String password;
}