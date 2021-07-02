package com.DeepDesignPattern.ProxyPattern.Dynamic;

/**
 * @Description:
 * @Author: swengcode
 * @Date: 2019/12/2316:49
 */
public class Client {

    public static void main(String[] args) {


        DynamicFactory dynamicFactory = new DynamicFactory(new TeacherDao());
        ITeach instance = (ITeach)dynamicFactory.getInstance();

        instance.Teach();
        //instance.dupMethod(1).dupMethod(2);
        ITeach iTeach = instance.dupMethod(1);
        System.out.println(iTeach.getClass());

    }

}
