package com.zpy.xiaobingservice.mapper;

import com.zpy.xiaobingservice.entity.Ordertype;
import com.zpy.xiaobingservice.qo.OrderTypeQo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface OrdertypeMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Ordertype record);

    int insertSelective(Ordertype record);

    Ordertype selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Ordertype record);

    int updateByPrimaryKey(Ordertype record);

    List<Ordertype> findOrderTypes(OrderTypeQo orderTypeQo);
}