package com.sweng.TypeThink.GenericsType;

/**
 * @Description:
 * @Author: swengcode
 * @Date: 2019/9/2615:05
 */
public class CounteInteger {

    private static long counter;
    private final long id = counter++;

    @Override
    public String toString() {
        return Long.toString(id);
    }
}
