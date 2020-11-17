package com.lhy.boot.api;

import com.lhy.boot.common.anno.ExceptionIntercept;
import com.lhy.boot.common.resp.BaseResponse;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author liuhaiyan
 * @date 2020-11-17 11:28
 */
@RestController
public class TestControler {

    @RequestMapping("/test")
    @ExceptionIntercept
    public BaseResponse test(@RequestParam("a") Integer a){
        if (a == 1){
            return new BaseResponse(1,a+"");
        }
        else if (a == 2){
            throw new NullPointerException();
        }
        else throw new RuntimeException();
    }
}

