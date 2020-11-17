package com.lhy.boot.common.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * 收集异常处理器的类
 * ExceptionMethodPool 里面按序存放所有异常处理器，excutor是执行这些异常处理器的对象
 * @author liuhaiyan
 * @date 2020-11-17 11:08
 */
public class ExceptionMethodPool {
    private List<ExceptionMethod> methods;
    private Object excutor;

    public ExceptionMethodPool(Object excutor) {
        this.methods = new ArrayList<ExceptionMethod>();
        this.excutor = excutor;
    }

    public Object getExcutor() {
        return excutor;
    }

    public void add(Class<? extends Throwable> clazz, Method method) {
        methods.add(new ExceptionMethod(clazz, method));
    }

    //按序查找能够处理该异常的处理器
    public Method obtainMethod(Throwable throwable) {
        return methods
                .stream()
                .filter(e -> e.getClazz().isAssignableFrom(throwable.getClass()))
                .findFirst()
                .orElseThrow(() ->new RuntimeException("没有找到对应的异常处理器"))
                .getMethod();
    }

    @AllArgsConstructor
    @Getter
    /**
     * clazz：这个代表着能够处理的异常
     * method：代表着处理异常调用的方法
     */
    class ExceptionMethod {
        private Class<? extends Throwable> clazz;
        private Method method;
    }
}

