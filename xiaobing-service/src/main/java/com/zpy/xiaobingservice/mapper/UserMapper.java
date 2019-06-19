package com.zpy.xiaobingservice.mapper;

import com.zpy.xiaobingservice.entity.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
    int insert(User record);

    int insertSelective(User record);

    User getUserById(String userId);

    boolean login(User user);
}