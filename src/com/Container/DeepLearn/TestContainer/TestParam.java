package com.Container.DeepLearn.TestContainer;

/**
 * @Description:
 * @Author: swengcode
 * @Date: 2019/12/213:34
 */
public class TestParam {

    public final int looper;
    public final int size;

    public TestParam(int looper, int size) {
        this.looper = looper;
        this.size = size;
    }

    //返回TestParam数组， 传入参数param
    public static TestParam[] array(int ... param){

        int size = param.length / 2;

        TestParam[] arrayParam = new TestParam[size];

        int n = 0;

        for (int i = 0; i < size; i++) {
            arrayParam[i] = new TestParam(param[n++],param[n++]);
        }

        return arrayParam;
    }

    //传入的参数String类型的
    public static TestParam[] array(String[] param){

        int[] vals = new int[param.length];

        for (int i = 0; i < param.length; i++) {

            vals[i] = Integer.valueOf(param[i]);

        }

        return array(vals);
    }


}
