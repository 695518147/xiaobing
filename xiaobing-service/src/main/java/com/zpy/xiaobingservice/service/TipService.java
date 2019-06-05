package com.zpy.xiaobingservice.service;

import com.zpy.xiaobingservice.entity.Tip;
import com.zpy.xiaobingservice.mapper.TipMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class TipService {

    @Resource
    private TipMapper tipMapper;
    public Tip insert(Tip tip) {
        tipMapper.insert(tip);
        return tip;
    }

    public Tip update(Tip tip) {
        tipMapper.updateByPrimaryKey(tip);
        return tip;
    }

    public int delete(Integer tipId) {
        return tipMapper.deleteByPrimaryKey(tipId);
    }
}
