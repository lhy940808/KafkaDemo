package com.lhy.boot.common.exception;

import com.lhy.boot.common.anno.ExceptionAdvice;
import com.lhy.boot.common.anno.ExceptionHandler;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * ExceptionBeanPostProcessor 通过实现BeanPostProcessor 接口，
 * 在bean初始化之前，把所有异常处理器塞进 ExceptionMethodPool,并把其注册进Spring容器
 * @author liuhaiyan
 * @date 2020-11-17 11:10
 */
@Component
public class ExceptionBeanPostProcessor implements BeanPostProcessor {

    private ExceptionMethodPool exceptionMethodPool;
    @Autowired
    private ConfigurableApplicationContext context;

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        Class<?> clazz = bean.getClass();
        System.out.println("beanname:" + beanName);
        ExceptionAdvice advice = clazz.getAnnotation(ExceptionAdvice.class);
        if (advice == null) return bean;
        if (exceptionMethodPool != null) throw new RuntimeException("不允许有两个异常定义类");
        exceptionMethodPool = new ExceptionMethodPool(bean);

        //保持处理异常方法顺序
        Arrays.stream(clazz.getDeclaredMethods())
                .filter(method -> method.getAnnotation(ExceptionHandler.class) != null)
                .forEach(method -> {
                    ExceptionHandler exceptionHandler = method.getAnnotation(ExceptionHandler.class);
                    Arrays.stream(exceptionHandler.value()).forEach(c -> exceptionMethodPool.add(c,method));
                });
        //注册进spring容器
        context.getBeanFactory().registerSingleton("exceptionMethodPool",exceptionMethodPool);
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object o, String s) throws BeansException {
        return o;
    }
}
