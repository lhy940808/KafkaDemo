package com.lhy.boot.api;

import com.lhy.boot.common.anno.ExceptionAdvice;
import com.lhy.boot.common.anno.ExceptionHandler;
import com.lhy.boot.common.resp.BaseResponse;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * @author liuhaiyan
 * @date 2020-11-17 11:27
 */

@ExceptionAdvice
@Service("ExceptionConfig")
public class ExceptionConfig {

    public  void print() {
        System.out.println("hhhh");
    }

    @ExceptionHandler(value = NullPointerException.class)
    public BaseResponse process(NullPointerException e){
        return new BaseResponse(0,"NPE");
    }

//    @ExceptionHandler(value = RuntimeException.class)
//    public BaseResponse process(Exception e){
//        return new BaseResponse(0,"Ex");
//    }

}
