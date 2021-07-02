package com.DesignPattern.DependentInversionPattern.Drive;

/**
 * @Description:
 * @Author: swengcode
 * @Date: 2019/9/2915:38
 */
public class Test {

    /*
    依赖倒置原则：

    1.模块间的依赖通过抽象发生，实体类之间不直接发生依赖关系，依赖都是通过抽象产生

    2.抽象不依赖细节  （抽象是指抽象类和接口）

    3.细节依赖抽象    （细节是指实体类的对象）


    现在有一简单的需求：

        一个业务场景： 一个司机准备开车

         错误的设计：司机直接依赖car和并直接去调用驾驶汽车的方法

         正确的设计： 将车开一个接口方便不同的车型   将驾驶开一个接口扩展不同的驾驶业务。

     */

    public static void main(String[] args) {

        ICar car = new BMW();
        IDriver newdriver  = new Driver();

        newdriver.driver(car);


    }



}
