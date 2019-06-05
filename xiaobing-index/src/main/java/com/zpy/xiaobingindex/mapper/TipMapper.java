package com.zpy.xiaobingindex.mapper;

import com.zpy.xiaobingindex.entity.Tip;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
*  @author author
*/
@Mapper
public interface TipMapper {

    List<Tip> queryTips();
}