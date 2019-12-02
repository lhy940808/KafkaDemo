package com.lhy.boot.service;

import com.lhy.boot.dao.UserMapper;
import com.lhy.boot.dao.model.User;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author liuhaiyan
 * @date 2019-11-12 14:27
 */
@Service
public class ServiceB {
    @Resource
    private UserMapper userMapper;

    public void methodB() {
        System.out.println("methodb is begin ---");
        User user = new User();
        user.setAge(12);
        user.setUserName("methodb");
        userMapper.insert(user);
        throw new RuntimeException("error methodb");
    }


}
