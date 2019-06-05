package com.zpy.xiaobingservice.entity;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

@Data
public class Tip {

    private Integer tipId;
    private Integer tipType;
    private String tipContent;
    @JsonFormat( pattern="yyyy-MM-dd HH:mm:ss")
    private Date createTime;
    private boolean isShow;
    private int number;

}
