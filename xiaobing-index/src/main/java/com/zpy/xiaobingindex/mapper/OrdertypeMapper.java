package com.zpy.xiaobingindex.mapper;

import com.zpy.xiaobingindex.qo.OrderTypeQo;
import org.apache.ibatis.annotations.Mapper;
import com.zpy.xiaobingindex.entity.Ordertype;

import java.util.List;

/**
*  @author author
*/
@Mapper
public interface OrdertypeMapper{

    List<Ordertype> queryOrdertype(Ordertype object);

    List<Ordertype> findOrderTypes(OrderTypeQo orderTypeQo);
}