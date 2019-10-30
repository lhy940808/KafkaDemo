package com.lhy.boot.api;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.lhy.boot.dao.model.User;
import com.lhy.boot.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author liuhaiyan
 * @date 2019-10-30 15:49
 */
@RestController
@Slf4j
//@RequestMapping("/spring")
public class HelloController {
    @Autowired
    private UserService userService;

    // 查询数据库一条记录
//    @RequestMapping(value="/query", method= RequestMethod.GET)
    @RequestMapping("/query")
    public String getUserById(@RequestParam(value="id") int id) {
        log.info("begin query data!!!");
        User user = userService.getUserById(id);

        Gson gson = new GsonBuilder().create();
        String json = gson.toJson(user);
        return json;
    }

}
