package com.zpy.xiaobingindex.controller;

import com.zpy.xiaobingindex.entity.Ordertype;
import com.zpy.xiaobingindex.mapper.OrdertypeMapper;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@RequestMapping("/xiaobing")
@RestController
public class OrderTypeController {

    @Resource
    private OrdertypeMapper ordertypeMapper;

    /**
     * 包含搜有子类
     * @return
     */
    @GetMapping("/orderTypes")
    @Cacheable(value = "orderTypes" ,key = "targetClass + methodName +#p0")
    public List<Ordertype> findAll(){
        Ordertype ordertype = new Ordertype();
        return ordertypeMapper.queryOrdertype(ordertype);
    }

    /**
     * 只包含第一个子类
     * @return
     */
    @GetMapping("/orderType/list")
    @Cacheable(value = "orderTypes" ,key = "targetClass + methodName +#p0")
    public List<Ordertype> queryAll(){
        Ordertype ot = new Ordertype();
        List<Ordertype> ordertypes = ordertypeMapper.queryOrdertypeList(ot);
        final int[] count = new int[]{0};
        ordertypes.forEach(ordertype->{
            if(count[0]++ != 0){
                ordertype.setOrders(new ArrayList<>());
            }
        });
        return ordertypes;
    }

    @GetMapping("/clear/orderTypes")
    @CacheEvict(value = "orderTypes",allEntries = true)
    public void clear(){

    }

}
