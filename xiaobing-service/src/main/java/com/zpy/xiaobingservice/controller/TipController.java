package com.zpy.xiaobingservice.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zpy.xiaobingservice.base.PageVo;
import com.zpy.xiaobingservice.entity.Tip;
import com.zpy.xiaobingservice.qo.TipQo;
import com.zpy.xiaobingservice.service.TipService;
import org.springframework.cache.annotation.CachePut;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RequestMapping("/xiaobing")
@RestController
public class TipController {

    @Resource
    private TipService tipService;

    @PostMapping("/tip")
//    @CachePut
    public Tip insert(@RequestBody Tip tip){
        return tipService.insert(tip);
    }

    @PutMapping("/tip")
//    @CachePut
    public Tip update(@RequestBody Tip tip){
        return tipService.update(tip);
    }

    @DeleteMapping("/tip/{tipId}")
//    @CachePut
    public int delete(@PathVariable("tipId") Integer tipId){
        return tipService.delete(tipId);
    }

    @PostMapping("/tip/list")
    public PageInfo<Tip> findTips(@RequestBody TipQo tipQo, PageVo pageVo){

        PageHelper.startPage(pageVo.getPageNum(),pageVo.getPageSize(),pageVo.getOrderBy());
        List<Tip> orders = tipService.findTips(tipQo);
        PageInfo<Tip> pageInfo = new PageInfo(orders);

        return pageInfo;
    }
}
