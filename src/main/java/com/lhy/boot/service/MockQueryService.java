package com.lhy.boot.service;

import java.util.concurrent.Future;

/**
 * 模拟查询动作
 * @author liuhaiyan
 * @date 2020-06-19 14:32
 */
public interface MockQueryService {

   Future<Integer> queryA(String parentThreadName);

   Future<Integer> queryB(String parentThreadname);

   Future<Integer> queryC(String parentThreadName);

   Future<Integer> queryD(String parentThreadname);

}
