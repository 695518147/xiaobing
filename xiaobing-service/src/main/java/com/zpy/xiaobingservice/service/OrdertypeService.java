package com.zpy.xiaobingservice.service;

import com.zpy.xiaobingservice.entity.Order;
import com.zpy.xiaobingservice.entity.Ordertype;
import com.zpy.xiaobingservice.mapper.OrderMapper;
import com.zpy.xiaobingservice.mapper.OrdertypeMapper;
import com.zpy.xiaobingservice.qo.OrderTypeQo;
import jdk.nashorn.internal.ir.IfNode;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class OrdertypeService {

    @Resource
    private OrdertypeMapper ordertypeMapper;
    @Resource
    private OrderMapper orderMapper;

    public Ordertype update(Ordertype ordertype) {
        ordertypeMapper.updateByPrimaryKeySelective(ordertype);
        return ordertypeMapper.selectByPrimaryKey(ordertype.getId());
    }

    public Ordertype insert(Ordertype ordertype) {
        ordertypeMapper.insert(ordertype);
        return ordertypeMapper.selectByPrimaryKey(ordertype.getId());
    }

    public int delete(Integer ordertypeId) {
        int count = orderMapper.selectByOrderTypeId(ordertypeId);
        if (count > 0) {
            return -1;
        }
        int row = ordertypeMapper.deleteByPrimaryKey(ordertypeId);
        return row;
    }

    public List<Ordertype> findOrderTypes(OrderTypeQo orderTypeQo) {
        return ordertypeMapper.findOrderTypes(orderTypeQo);
    }
}
