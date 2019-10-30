package com.lhy.boot.service.impl;

import com.lhy.boot.dao.UserMapper;
import com.lhy.boot.dao.model.User;
import com.lhy.boot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author liuhaiyan
 * @date 2019-10-30 15:58
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User getUserById(int id) {
        User user = userMapper.selectByPrimaryKey((long)id);
        return user;
    }
}
