package com.zpy.xiaobingindex.entity;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
*
*  @author author
*/
@Data
public class Ordertype implements Serializable {

    private static final long serialVersionUID = 1556295159179L;


    private Integer id;

    private String orderTypeName;

    private Integer number;

    private Date createTime;

    private boolean isShow;

    List<Order> orders;

}
