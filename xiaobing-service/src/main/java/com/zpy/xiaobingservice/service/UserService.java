package com.zpy.xiaobingservice.service;

import com.zpy.xiaobingservice.entity.User;
import com.zpy.xiaobingservice.mapper.UserMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserService {

    @Resource
    private UserMapper userMapper;

    public User getUserById(String userId){
        return userMapper.getUserById(userId);
    }

    public boolean login(User user) {
        return userMapper.login(user);
    }
}
