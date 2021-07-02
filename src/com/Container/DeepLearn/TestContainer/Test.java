package com.Container.DeepLearn.TestContainer;

/**
 * @Description:
 * @Author: swengcode
 * @Date: 2019/12/213:31
 */
public abstract class Test<C> {
    private String name;

    public Test(String name) {

        this.name = name;

    }

    public String getName() {
        return name;
    }

    public abstract int test(C contain, TestParam pt);
}
