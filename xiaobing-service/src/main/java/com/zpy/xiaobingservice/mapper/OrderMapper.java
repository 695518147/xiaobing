package com.zpy.xiaobingservice.mapper;

import com.zpy.xiaobingservice.entity.Order;
import com.zpy.xiaobingservice.qo.OrderQo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface OrderMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Order record);

    int insertSelective(Order record);

    Order selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Order record);

    int updateByPrimaryKey(Order record);

    int selectByOrderTypeId(Integer ordertypeId);

    List<Order> findOrders(OrderQo orderQo);
}