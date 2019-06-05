package com.zpy.xiaobingservice.service;

import com.zpy.xiaobingservice.entity.Order;
import com.zpy.xiaobingservice.mapper.OrderMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class OrderService {

    @Resource
    private OrderMapper orderMapper;

    public Order insert(Order order) {
        orderMapper.insert(order);
        return order;
    }

    public Order update(Order order) {
        orderMapper.updateByPrimaryKey(order);
        return order;
    }

    public int delete(Integer orderId) {
        return orderMapper.deleteByPrimaryKey(orderId);
    }
}
