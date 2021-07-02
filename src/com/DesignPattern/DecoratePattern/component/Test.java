package com.DesignPattern.DecoratePattern.component;

/**
 * @Description:
 * @Author: swengcode
 * @Date: 2019/10/816:18
 */
public class Test {

    /*
          装饰者模式：
          Component抽象构件：                    是核心的接口

          ConcreteComponent具体构件：            实现核心接口实现类，装饰的对象

          Decorate装饰角色:                     装饰类，继承抽象Component组成结构，重写方法，里面必有一个Component组件对象

          ConcreteDecorate具体装饰角色：         装饰类的实现类，添加新的装饰方法


     */


    public static void main(String[] args) {

        Component component = new ConcreteComponent();

        Decorate decorate  =new  ConcreteDecorate(component);

        decorate.operation();

        decorate = new ConcreteDecorate2(component);

        decorate.operation();

    }

}
