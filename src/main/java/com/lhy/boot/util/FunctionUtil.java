package com.lhy.boot.util;

import com.lhy.boot.common.ThrowExceptionFunction;
import com.lhy.boot.common.ThrowExceptionSupplier;

/**
 * @author liuhaiyan
 * @date 2020-11-17 11:15
 */
public class FunctionUtil {

    public static <T, R> R computeOrGetDefault(ThrowExceptionFunction<T, R> function, T t, R r) {
        try {
            return function.apply(t);
        } catch (Exception e) {
            return r;
        }
    }
    public static <R> R computeOrGetDefault(ThrowExceptionSupplier<R> supplier, R r){
        try {
            return supplier.get();
        } catch (Exception e) {
            return r;
        }
    }

    public static void main(String[] args) {
        //返回0
        computeOrGetDefault(i -> {
            if (i < 0) throw new RuntimeException();
            else return i;
        }, -1, 0);
        //返回5
        computeOrGetDefault(i -> {
            if (i < 0) throw new RuntimeException();
            else return i;
        },5,0);
    }

}
