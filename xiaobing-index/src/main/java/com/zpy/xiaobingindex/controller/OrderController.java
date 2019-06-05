package com.zpy.xiaobingindex.controller;


import com.zpy.xiaobingindex.mapper.OrderMapper;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.zpy.xiaobingindex.entity.Order;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/xiaobing")
public class OrderController {

    @Resource
    private OrderMapper orderMapper;

    @GetMapping("/orders")
    @Cacheable(value = "orders" ,key = "targetClass + methodName +#p0")
    public List<Order> findAll(){
        Order order = new Order();
        return orderMapper.queryOrder(order);
    }

}
