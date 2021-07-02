package com.Container.DeepLearn.Set;

/**
 * @Description:
 * @Author: swengcode
 * @Date: 2019/11/2713:58
 */
public class SetType {

    int i;

    public SetType(int i) {
        this.i = i;
    }

    @Override
    public boolean equals(Object obj) {
        //return super.equals(obj);

        return (obj instanceof SetType) && i == (((SetType)obj).i);

    }

    @Override
    public String toString() {
        return "SetType{" +
                "i=" + i +
                '}';
    }
}
