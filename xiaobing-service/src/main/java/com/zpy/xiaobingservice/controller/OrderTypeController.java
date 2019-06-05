package com.zpy.xiaobingservice.controller;

import com.zpy.xiaobingservice.entity.Ordertype;
import com.zpy.xiaobingservice.service.OrdertypeService;
import org.springframework.cache.annotation.CachePut;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RequestMapping("/xiaobing")
@RestController
public class OrderTypeController {

    @Resource
    private OrdertypeService ordertypeService;

    @PostMapping("/ordertype")
//    @CachePut
    public Ordertype insert(@RequestBody Ordertype ordertype){
        return ordertypeService.insert(ordertype);
    }

    @PutMapping("/ordertype")
//    @CachePut
    public Ordertype update(@RequestBody Ordertype ordertype){
        return ordertypeService.update(ordertype);
    }

    @DeleteMapping("/ordertype/{ordertypeId}")
//    @CachePut
    public int delete(@PathVariable("ordertypeId") Integer ordertypeId){
        return ordertypeService.delete(ordertypeId);
    }

}
