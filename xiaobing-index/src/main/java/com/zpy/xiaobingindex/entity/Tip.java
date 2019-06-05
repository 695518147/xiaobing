package com.zpy.xiaobingindex.entity;


import lombok.Data;

import java.util.Date;

@Data
public class Tip {

    private Integer tipId;
    private Integer tipType;
    private String tipContent;
    private Date createTime;
    private boolean isShow;
    private int number;

}
