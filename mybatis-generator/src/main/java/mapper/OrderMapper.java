package mapper;

import entity.Order;
import entity.OrderWithBLOBs;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface OrderMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(OrderWithBLOBs record);

    int insertSelective(OrderWithBLOBs record);

    OrderWithBLOBs selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(OrderWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(OrderWithBLOBs record);

    int updateByPrimaryKey(Order record);
}