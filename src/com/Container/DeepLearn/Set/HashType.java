package com.Container.DeepLearn.Set;

/**
 * @Description:
 * @Author: swengcode
 * @Date: 2019/11/2714:02
 */
public class HashType extends SetType {

    public HashType(int i) {
        super(i);
    }

    @Override
    public int hashCode() {
        return i;
    }
}
