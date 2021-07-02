package com.DesignPattern.DecoratePattern.component;

/**
 * @Description:
 * @Author: swengcode
 * @Date: 2019/10/816:17
 */
public class ConcreteDecorate2 extends Decorate {

    public ConcreteDecorate2(Component component) {
        super(component);
    }

    public void method2(){

        System.out.println("method2");

    }

    @Override
    public void operation() {
        this.method2();
        super.operation();
    }
}
