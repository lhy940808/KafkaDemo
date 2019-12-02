package com.lhy.boot.service;

import com.lhy.boot.dao.UserMapper;
import com.lhy.boot.dao.model.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 *
 * 事务专用类
 * @author liuhaiyan
 * @date 2019-11-12 14:26
 */
@Service
public class ServiceA {
    @Resource
    private UserMapper userMapper;
    @Resource
    private ServiceB serviceB;

    @Transactional(rollbackFor = Exception.class)
    public void methodA() {
        User user = new User();
        user.setUserName("methoda");
        user.setAge(100);
        user.setSex("a");
        userMapper.insert(user);
        try {
            serviceB.methodB();
        }catch(Exception e) {
            System.out.println("methoda catch methodb exception");
            System.out.println("exception is " + e.getMessage());
        }
    }

    /**
     * @Description :B发生异常，Acatch了异常，记录日志，抛出异常A回滚，B回滚
     * @params []
     * @return void
     * @author liuhaiyan
     * @date 2019-11-12 15:07
     */
    @Transactional(rollbackFor=Exception.class)
    public void methodA1() {
        User user = new User();
        user.setUserName("methoda11111");
        user.setAge(100);
        user.setSex("a");
        userMapper.insert(user);
        try {
            serviceB.methodB();
        }catch(Exception e) {
            System.out.println("methoda catch methodb exception");
            System.out.println("exception is " + e.getMessage());
            throw new RuntimeException("methoda111 exception ");
        }
    }
}
