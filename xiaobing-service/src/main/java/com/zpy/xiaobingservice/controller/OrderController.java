package com.zpy.xiaobingservice.controller;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zpy.xiaobingservice.base.PageVo;
import com.zpy.xiaobingservice.entity.Order;
import com.zpy.xiaobingservice.qo.OrderQo;
import com.zpy.xiaobingservice.service.OrderService;
import com.zpy.xiaobingservice.utils.HttpclientUtil;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/xiaobing")
public class OrderController {

    @Resource
    private OrderService orderService;

    @PostMapping("/order")
    public Order insert(@RequestBody Order order){
            clearn();
            return orderService.insert(order);
    }

    @PutMapping("/order")
    public Order update(@RequestBody Order order){
        clearn();
        return orderService.update(order);
    }

    @DeleteMapping("/order/{orderId}")
    public int delete(@PathVariable("orderId") Integer orderId){
        clearn();
        return orderService.delete(orderId);
    }

    @PostMapping("/order/list")
    public PageInfo<Order> findOrders(@RequestBody OrderQo orderQo, PageVo pageVo){

        PageHelper.startPage(pageVo.getPageNum(),pageVo.getPageSize(),pageVo.getOrderBy());
        List<Order> orders = orderService.findOrders(orderQo);
        PageInfo<Order> pageInfo = new PageInfo(orders);

        return pageInfo;
    }

    public void clearn(){
        try {
            HttpclientUtil.doGet("http://120.78.205.51:7070/xiaobing/clear/orderTypes");
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
