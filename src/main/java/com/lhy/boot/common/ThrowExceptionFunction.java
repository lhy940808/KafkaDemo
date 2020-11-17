package com.lhy.boot.common;

/**
 * @author liuhaiyan
 * @date 2020-11-17 11:16
 */
@FunctionalInterface
public interface ThrowExceptionFunction<T, R> {
    R apply(T t) throws Exception;
}


