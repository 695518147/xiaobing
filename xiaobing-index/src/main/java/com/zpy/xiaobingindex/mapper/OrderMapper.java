package com.zpy.xiaobingindex.mapper;

import org.apache.ibatis.annotations.Mapper;
import com.zpy.xiaobingindex.entity.Order;

import java.util.List;

/**
*  @author author
*/
@Mapper
public interface OrderMapper{

    int insertOrder(Order object);

    int updateOrder(Order object);

    List<Order> queryOrder(Order object);

    Order queryOrderLimit1(Order object);
}