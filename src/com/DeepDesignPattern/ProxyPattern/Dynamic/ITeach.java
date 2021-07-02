package com.DeepDesignPattern.ProxyPattern.Dynamic;

/**
 * @Description:
 * @Author: swengcode
 * @Date: 2019/12/2316:43
 */
public interface ITeach {

    void Teach();

    ITeach dupMethod(Integer args);

}
