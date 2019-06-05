package com.zpy.xiaobingservice.controller;


import com.zpy.xiaobingservice.entity.Order;
import com.zpy.xiaobingservice.service.OrderService;
import org.springframework.cache.annotation.CachePut;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/xiaobing")
public class OrderController {

    @Resource
    private OrderService orderService;

    @PostMapping("/order")
//    @CachePut
    public Order insert(@RequestBody Order order){
        return orderService.insert(order);
    }

    @PutMapping("/order")
//    @CachePut
    public Order update(@RequestBody Order order){
        return orderService.update(order);
    }

    @DeleteMapping("/order/{orderId}")
//    @CachePut
    public int delete(@PathVariable("orderId") Integer orderId){
        return orderService.delete(orderId);
    }

}
