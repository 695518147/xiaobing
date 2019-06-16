package com.zpy.xiaobingservice.service;

import com.zpy.xiaobingservice.entity.Tip;
import com.zpy.xiaobingservice.mapper.TipMapper;
import com.zpy.xiaobingservice.qo.TipQo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Service
public class TipService {

    @Resource
    private TipMapper tipMapper;
    public Tip insert(Tip tip) {
        tip.setCreateTime(new Date());
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

    public List<Tip> findTips(TipQo tipQo) {
        return tipMapper.findTips(tipQo);

    }
}
