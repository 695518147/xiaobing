package com.zpy.xiaobingservice.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zpy.xiaobingservice.base.PageVo;
import com.zpy.xiaobingservice.entity.Ordertype;
import com.zpy.xiaobingservice.qo.OrderTypeQo;
import com.zpy.xiaobingservice.service.OrdertypeService;
import com.zpy.xiaobingservice.utils.HttpclientUtil;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@RequestMapping("/xiaobing")
@RestController
public class OrderTypeController {

    @Resource
    private OrdertypeService ordertypeService;

    @PostMapping("/ordertype")
    public Ordertype insert(@RequestBody Ordertype ordertype){
        clearn();
        return ordertypeService.insert(ordertype);
    }

    @PutMapping("/ordertype")
    public Ordertype update(@RequestBody Ordertype ordertype){
        clearn();
        return ordertypeService.update(ordertype);
    }

    @DeleteMapping("/ordertype/{ordertypeId}")
    public int delete(@PathVariable("ordertypeId") Integer ordertypeId){
        clearn();
        return ordertypeService.delete(ordertypeId);
    }

    @PostMapping("/ordertype/list")
    public PageInfo<Ordertype> findOrderTypes(@RequestBody OrderTypeQo orderTypeQo, PageVo pageVo){

        PageHelper.startPage(pageVo.getPageNum(),pageVo.getPageSize(),pageVo.getOrderBy());
        List<Ordertype> ordertypes = ordertypeService.findOrderTypes(orderTypeQo);
        PageInfo<Ordertype> pageInfo = new PageInfo(ordertypes);

        return pageInfo;
    }

    public void clearn(){
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        executorService.execute(()-> {
            try {
                HttpclientUtil.doGet("http://120.78.205.51:7070/xiaobing/clear/orderTypes");
                HttpclientUtil.doGet("http://120.78.205.51:7070/xiaobing/orderTypes");
                HttpclientUtil.doGet("http://120.78.205.51:7070/xiaobing/orderType/list");
            }catch (Exception e){
                e.printStackTrace();
            }
        });
    }
}
