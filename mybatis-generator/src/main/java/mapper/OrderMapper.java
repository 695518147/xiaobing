package mapper;

import entity.OrderWithBLOBs;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface OrderMapper {
    int insert(OrderWithBLOBs record);

    int insertSelective(OrderWithBLOBs record);
}