package com.Container.DeepLearn.Set;

import java.util.Set;

/**
 * @Description:
 * @Author: swengcode
 * @Date: 2019/11/2714:02
 */
public class TreeType extends SetType implements Comparable<TreeType> {
    public TreeType(int i) {
        super(i);
    }
    @Override
    public int compareTo(TreeType o) {
        return (i < o.i ? -1 : (o.i == i ? 0 : 1));
    }
}
