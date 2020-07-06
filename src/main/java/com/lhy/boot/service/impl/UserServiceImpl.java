package com.lhy.boot.service.impl;


import com.lhy.boot.dao.UserMapper;
import com.lhy.boot.dao.model.User;
import com.lhy.boot.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author liuhaiyan
 * @date 2019-10-30 15:58
 */
@Service
@Slf4j
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User getUserById(int id) {
        User user = userMapper.selectByPrimaryKey((long)id);
        return user;
    }

    @Override
    @Transactional
    public Long insertAndUpdate() {
        User insertUser = new User();
        insertUser.setAge(20);
        insertUser.setSex("feman");
        insertUser.setUserName("事务A");
        userMapper.insertSelective(insertUser);
        log.info("insert user end, user:{}", insertUser.toString());
        insertUser.setUserName("事务B");
        updateUser(insertUser);
        return insertUser.getId();
    }
//    @Transactional
    private void updateUser(User user) {
        log.info("update user is :{}", user);
        userMapper.updateByPrimaryKey(user);
        throw new RuntimeException("mock exception");
    }
}
