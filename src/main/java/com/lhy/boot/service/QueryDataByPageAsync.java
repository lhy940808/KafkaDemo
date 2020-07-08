package com.lhy.boot.service;

import com.lhy.boot.dao.model.User;

import java.util.List;

/**
 * 模拟用多线程去读取数据库的数据
 * @author liuhaiyan
 * @date 2020-07-06 16:25
 */
public interface QueryDataByPageAsync {

    List<User> queryUserAsync();
}
