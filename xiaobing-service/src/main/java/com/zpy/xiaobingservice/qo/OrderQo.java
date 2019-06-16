package com.zpy.xiaobingservice.qo;

import lombok.Data;

@Data
public class OrderQo {

    private String orderName;
    private Boolean isShow;
    private Boolean isSplit;
    private String orderDescription;
    private String orderTypeDescription;
    private Integer orderTypeId;
}
