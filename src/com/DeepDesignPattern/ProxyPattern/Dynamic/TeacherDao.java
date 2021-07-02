package com.DeepDesignPattern.ProxyPattern.Dynamic;

/**
 * @Description:
 * @Author: swengcode
 * @Date: 2019/12/2316:43
 */
public class TeacherDao implements ITeach {
    @Override
    public void Teach() {

        System.out.println("老师正在授课");

    }

    @Override
    public ITeach dupMethod(Integer args) {

        System.out.println(args);
        return this;

    }
}
