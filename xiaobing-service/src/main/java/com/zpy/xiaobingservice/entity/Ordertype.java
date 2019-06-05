package com.zpy.xiaobingservice.entity;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
*
*  @author author
*/
@Data
public class Ordertype implements Serializable {

    private static final long serialVersionUID = 1556295159179L;


    /**
    * 主键
    * 
    * isNullAble:0
    */
    private Integer id;

    /**
    * 
    * isNullAble:0
    */
    private String orderTypeName;

    /**
    * 
    * isNullAble:0
    */
    private Integer number;

    /**
    * 
    * isNullAble:0
    */
    private java.time.LocalDateTime createTime;

    List<Order> orders;

    /**
     *
     * isNullAble:0
     */
    private boolean isShow;



}
