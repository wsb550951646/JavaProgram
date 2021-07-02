package com.Container.DeepLearn.TestContainer;

import java.util.*;

/**
 * @Description:
 * @Author: swengcode
 * @Date: 2019/12/215:00
 */
public class CouterInterList extends ArrayList<Integer> {

    private int size;
    public CouterInterList(int size) {
        this.size = size;
        for (int i = 0; i < size; i++) {
            add(i);
        }

    }

}
