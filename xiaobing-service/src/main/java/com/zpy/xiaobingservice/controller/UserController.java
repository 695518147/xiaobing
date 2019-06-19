package com.zpy.xiaobingservice.controller;

import com.zpy.xiaobingservice.entity.User;
import com.zpy.xiaobingservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@RequestMapping("/xiaobing")
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/user")
    public User getUserById(@RequestParam("userId") String userId){
        return userService.getUserById(userId);
    }

    @PostMapping("/login")
    public Map login(@RequestBody User user, HttpServletRequest request){
        boolean flag = userService.login(user);
        request.getSession().setAttribute("loginFlag",flag);
        Map map = new HashMap();
        map.put("token", "admin-token");
        map.put("loginFlag", flag);

        return map;
    }
}
