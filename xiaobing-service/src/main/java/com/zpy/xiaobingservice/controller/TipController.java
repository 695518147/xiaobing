package com.zpy.xiaobingservice.controller;

import com.zpy.xiaobingservice.entity.Tip;
import com.zpy.xiaobingservice.service.TipService;
import org.springframework.cache.annotation.CachePut;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

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

}
