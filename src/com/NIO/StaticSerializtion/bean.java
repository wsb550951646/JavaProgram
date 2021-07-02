package com.NIO.StaticSerializtion;

import java.io.Serializable;

/**
 * @Description:
 * @Author: swengcode
 * @Date: 2019/11/129:50
 */
public class bean implements Serializable {

    public static int i = 0;
    public static String s = "";

    private static final long serialVersionUID = -3737338076212523007L;

    public static int getI() {
        return i;
    }

    public static void setI(int i) {
        bean.i = i;
    }

    public static String getS() {
        return s;
    }

    public static void setS(String s) {
        bean.s = s;
    }

    @Override
    public String toString() {
        return "bean{id:"+i+" s:"+s+"}";
    }
}
