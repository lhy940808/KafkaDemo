package com.lhy.boot.service;

import com.lhy.boot.dao.model.User;

/**
 * @author liuhaiyan
 * @date 2019-10-30 15:57
 */
public interface UserService {

    User getUserById(int id);

    Long insertAndUpdate();
}
