package com.DesignPattern.DecoratePattern.component;

/**
 * @Description:
 * @Author: swengcode
 * @Date: 2019/10/816:15
 */
public class ConcreteDecorate extends Decorate {

    public ConcreteDecorate(Component component) {
        super(component);
    }

    public void method1(){

        System.out.println("method1");
    }

    @Override
    public void operation() {
        super.operation();
        this.method1();

    }
}
