package com.zpy.xiaobingservice.entity;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
*
*  @author author
*/
@Data
public class Order implements Serializable {

    private static final long serialVersionUID = 1556295147482L;

    private Integer id;
    private String orderName;
    private boolean isShow;
    private boolean isSplit;
    private String orderDescription;
    private String orderTypeDescription;
    private Integer number;
    private Date createTime;
    private Integer orderTypeId;



}
