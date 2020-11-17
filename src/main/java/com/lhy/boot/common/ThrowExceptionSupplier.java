package com.lhy.boot.common;

/**
 * @author liuhaiyan
 * @date 2020-11-17 11:17
 */
@FunctionalInterface
public interface ThrowExceptionSupplier<T> {
    T get() throws Exception;
}