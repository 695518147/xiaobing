package com.zpy.xiaobingservice.service;

import com.zpy.xiaobingservice.entity.Order;
import com.zpy.xiaobingservice.entity.Ordertype;
import com.zpy.xiaobingservice.mapper.OrdertypeMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class OrdertypeService {

    @Resource
    private OrdertypeMapper ordertypeMapper;
    public Ordertype update(Ordertype ordertype) {
        ordertypeMapper.updateByPrimaryKey(ordertype);
        return ordertype;
    }

    public Ordertype insert(Ordertype ordertype) {
        ordertypeMapper.insert(ordertype);
        return ordertype;
    }

    public int delete(Integer ordertypeId) {
        int row = ordertypeMapper.deleteByPrimaryKey(ordertypeId);
        return row;
    }
}
