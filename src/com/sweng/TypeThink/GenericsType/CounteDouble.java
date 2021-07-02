package com.sweng.TypeThink.GenericsType;

/**
 * @Description:
 * @Author: swengcode
 * @Date: 2019/9/2615:13
 */
public class CounteDouble {

    private static double counter2;
    private final double id = counter2++;

    @Override
    public String toString() {
        return Double.toString(id);
    }
}
