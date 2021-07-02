package com.sweng.TypeThink.GenericsType;

import java.util.Iterator;

/**
 * @Description:
 * @Author: swengcode
 * @Date: 2019/9/2615:32
 */
public class CountePerson {

    public static Integer counter3 = 0;
    public final Integer id = counter3++;
    public final String Name = "person"+id;

    @Override
    public String toString() {
        return Integer.toString(id)+":"+Name;
    }
}
