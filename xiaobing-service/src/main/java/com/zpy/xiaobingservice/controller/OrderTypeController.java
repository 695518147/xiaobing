package com.zpy.xiaobingservice.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zpy.xiaobingservice.base.PageVo;
import com.zpy.xiaobingservice.entity.Ordertype;
import com.zpy.xiaobingservice.qo.OrderTypeQo;
import com.zpy.xiaobingservice.service.OrdertypeService;
import org.springframework.cache.annotation.CachePut;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RequestMapping("/xiaobing")
@RestController
public class OrderTypeController {

    @Resource
    private OrdertypeService ordertypeService;

    @PostMapping("/ordertype")
    public Ordertype insert(@RequestBody Ordertype ordertype){
        return ordertypeService.insert(ordertype);
    }

    @PutMapping("/ordertype")
    public Ordertype update(@RequestBody Ordertype ordertype){
        return ordertypeService.update(ordertype);
    }

    @DeleteMapping("/ordertype/{ordertypeId}")
    public int delete(@PathVariable("ordertypeId") Integer ordertypeId){
        return ordertypeService.delete(ordertypeId);
    }

    @PostMapping("/ordertype/list")
    public PageInfo<Ordertype> findOrderTypes(@RequestBody OrderTypeQo orderTypeQo, PageVo pageVo){

        PageHelper.startPage(pageVo.getPageNum(),pageVo.getPageSize(),pageVo.getOrderBy());
        List<Ordertype> ordertypes = ordertypeService.findOrderTypes(orderTypeQo);
        PageInfo<Ordertype> pageInfo = new PageInfo(ordertypes);

        return pageInfo;
    }
}
