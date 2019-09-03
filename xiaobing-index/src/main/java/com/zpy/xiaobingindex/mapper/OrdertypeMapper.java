package com.zpy.xiaobingindex.mapper;

import org.apache.ibatis.annotations.Mapper;
import com.zpy.xiaobingindex.entity.Ordertype;

import java.util.List;

/**
*  @author author
*/
@Mapper
public interface OrdertypeMapper{

    List<Ordertype> queryOrdertype(Ordertype object);

    List<Ordertype> queryOrdertypeList(Ordertype ordertype);
}