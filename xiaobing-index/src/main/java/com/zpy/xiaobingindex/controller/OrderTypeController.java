package com.zpy.xiaobingindex.controller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zpy.xiaobingindex.base.PageVo;
import com.zpy.xiaobingindex.entity.Ordertype;
import com.zpy.xiaobingindex.mapper.OrdertypeMapper;
import com.zpy.xiaobingindex.qo.OrderTypeQo;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RequestMapping("/xiaobing")
@RestController
public class OrderTypeController {

    @Resource
    private OrdertypeMapper ordertypeMapper;

    @GetMapping("/orderTypes")
    @Cacheable(value = "orderTypes" ,key = "targetClass + methodName +#p0")
    public List<Ordertype> findAll(){
        Ordertype ordertype = new Ordertype();
        return ordertypeMapper.queryOrdertype(ordertype);
    }

    @PostMapping("/orderType/list")
    public PageInfo<Ordertype> findOrderTypes(@RequestBody OrderTypeQo orderTypeQo, PageVo pageVo){

        PageHelper.startPage(pageVo.getPageNum(),pageVo.getPageSize(),pageVo.getOrderBy());
        List<Ordertype> ordertypes = ordertypeMapper.findOrderTypes(orderTypeQo);
        PageInfo<Ordertype> pageInfo = new PageInfo(ordertypes);

        return pageInfo;
    }

    @GetMapping("/clear/orderTypes")
    @CacheEvict(value = "orderTypes",allEntries = true)
    public void clear(){

    }

}
