package com.lhy.boot.common.exception;

import com.lhy.boot.common.resp.BaseResponse;
import com.lhy.boot.util.FunctionUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * 异常处理器
 * @author liuhaiyan
 * @date 2020-11-17 11:12
 */
@Component
public class ExceptionProcessor {

    @Autowired
    private ExceptionMethodPool exceptionMethodPool;

    public BaseResponse process(Throwable e) {
        return (BaseResponse) FunctionUtil.computeOrGetDefault(() ->{
            Method method = exceptionMethodPool.obtainMethod(e);
            method.setAccessible(true);
            return method.invoke(exceptionMethodPool.getExcutor(),e);
        },new BaseResponse(0,"未知错误"));
    }
}
