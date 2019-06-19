package com.zpy.xiaobingservice.service;

import com.zpy.xiaobingservice.entity.Order;
import com.zpy.xiaobingservice.entity.Ordertype;
import com.zpy.xiaobingservice.mapper.OrderMapper;
import com.zpy.xiaobingservice.qo.OrderQo;
import com.zpy.xiaobingservice.qo.OrderTypeQo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class OrderService {

    @Resource
    private OrderMapper orderMapper;

    public Order insert(Order order) {
        orderMapper.insert(order);
        return order;
    }

    public Order update(Order order) {
        orderMapper.updateByPrimaryKeySelective(order);
        return orderMapper.selectByPrimaryKey(order.getId());
    }

    public int delete(Integer orderId) {
        return orderMapper.deleteByPrimaryKey(orderId);
    }

    public List<Order> findOrders(OrderQo orderQo) {

        return orderMapper.findOrders(orderQo);

    }
}
