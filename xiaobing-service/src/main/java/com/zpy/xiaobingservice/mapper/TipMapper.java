package com.zpy.xiaobingservice.mapper;

import com.zpy.xiaobingservice.entity.Tip;
import com.zpy.xiaobingservice.qo.TipQo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


/**
*  @author author
*/
@Mapper
public interface TipMapper {
    int deleteByPrimaryKey(Integer tipId);

    int insert(Tip record);

    int insertSelective(Tip record);

    Tip selectByPrimaryKey(Long tipId);

    int updateByPrimaryKeySelective(Tip record);

    int updateByPrimaryKey(Tip record);

    List<Tip> findTips(TipQo tipQo);
}