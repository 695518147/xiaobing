package com.zpy.xiaobingservice.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zpy.xiaobingservice.base.PageVo;
import com.zpy.xiaobingservice.entity.Tip;
import com.zpy.xiaobingservice.qo.TipQo;
import com.zpy.xiaobingservice.service.TipService;
import com.zpy.xiaobingservice.utils.HttpclientUtil;
import org.springframework.cache.annotation.CachePut;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@RequestMapping("/xiaobing")
@RestController
public class TipController {

    @Resource
    private TipService tipService;

    @PostMapping("/tip")
    public Tip insert(@RequestBody Tip tip){
        Tip tip1 = tipService.insert(tip);
        clearn();
        return tip1;
    }

    @PutMapping("/tip")
    public Tip update(@RequestBody Tip tip){
        Tip tip1 = tipService.update(tip);
        clearn();
        return tip1;
    }

    @DeleteMapping("/tip/{tipId}")
    public int delete(@PathVariable("tipId") Integer tipId){
        int row = tipService.delete(tipId);
        clearn();
        return row;
    }

    @PostMapping("/tip/list")
    public PageInfo<Tip> findTips(@RequestBody TipQo tipQo, PageVo pageVo){

        PageHelper.startPage(pageVo.getPageNum(),pageVo.getPageSize(),pageVo.getOrderBy());
        List<Tip> orders = tipService.findTips(tipQo);
        PageInfo<Tip> pageInfo = new PageInfo(orders);

        return pageInfo;
    }

    public void clearn(){
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        executorService.execute(()-> {
            try {
                HttpclientUtil.doGet("http://120.78.205.51:7070/xiaobing/clear/tips");
                HttpclientUtil.doGet("http://120.78.205.51:7070/xiaobing/tips");
            }catch (Exception e){
                e.printStackTrace();
            }
        });
    }
}
