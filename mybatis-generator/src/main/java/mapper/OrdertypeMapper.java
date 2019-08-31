package mapper;

import entity.Ordertype;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface OrdertypeMapper {
    int insert(Ordertype record);

    int insertSelective(Ordertype record);
}