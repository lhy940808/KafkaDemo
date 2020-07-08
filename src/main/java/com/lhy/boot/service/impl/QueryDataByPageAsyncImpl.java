package com.lhy.boot.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.lhy.boot.dao.UserMapper;
import com.lhy.boot.dao.model.User;
import com.lhy.boot.dao.model.UserExample;
import com.lhy.boot.service.QueryDataByPageAsync;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StopWatch;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

/**
 * @author liuhaiyan
 * @date 2020-07-06 16:28
 */
@Service
@Slf4j
public class QueryDataByPageAsyncImpl implements QueryDataByPageAsync {

    private static final Integer pageSIze = 3;

    private static ExecutorService executor =  new ThreadPoolExecutor(20, 50,
            60L, TimeUnit.MILLISECONDS, new ArrayBlockingQueue(80));

    @Resource
    private UserMapper userMapper;

    @Override
    public List<User> queryUserAsync() {
        log.info("begin query all data......");
        /**1 先查下库里有多少数据*/
        UserExample userExample = new UserExample();
        List<User> allUsers = userMapper.selectByExample(userExample);
        log.info("all user size : {}", allUsers.size());
        if (CollectionUtils.isEmpty(allUsers)) {
            return Collections.emptyList();
        }
        int page = allUsers.size() % pageSIze == 0 ? allUsers.size() / pageSIze : allUsers.size() / pageSIze + 1;
        log.info("begin query async, page:{}, pagesize:{}", page, pageSIze);
        List<Future<List<User>>> resFuture = new ArrayList<>();
        List<User> users = new ArrayList<>();
        long startTime = System.currentTimeMillis();
        for (int  i = 0; i < page; i++) {
            Future<List<User>>  future =
                    executor.submit(new QueryCallable<List<User>>(i, pageSIze));
            resFuture.add(future);
        }
        // 获取返回值
        for (int i = 0; i < resFuture.size(); i++) {
            try {
                List<User> tempusers = resFuture.get(i).get();
                if (!CollectionUtils.isEmpty(resFuture)) {
                    users.addAll(tempusers);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }


        log.info("end query all data......, users:{},cost:{}ms", JSONObject.toJSONString(users), System.currentTimeMillis() - startTime);
        return users;
    }

    private class QueryCallable<T> implements Callable {

        private Integer page;

        private Integer pageSize;

        public QueryCallable(Integer page, Integer pageSize) {
            this.page = page;
            this.pageSize = pageSize;
        }



        @Override
        public Object call() throws Exception {
            log.info("query data begin,page:{},pageSize:{}", page, pageSIze);
            long startTIme = System.currentTimeMillis();
            List<User> users = userMapper.queryUserBypage(page, pageSize);
            log.info("query data end,page:{},pageSize:{},res:{},cost:{}ms", page, pageSIze, JSONObject.toJSONString(users), System.currentTimeMillis() - startTIme);
            return users;
        }
    }
}
