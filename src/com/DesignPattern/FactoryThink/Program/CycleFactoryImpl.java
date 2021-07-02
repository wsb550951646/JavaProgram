package com.DesignPattern.FactoryThink.Program;

/**
 * @Description:
 * @Author: swengcode
 * @Date: 2019/9/2515:25
 */
public class CycleFactoryImpl implements Factory {
    @Override
    public Tricycle getTricycle() {
        System.out.println("do some for tri");
        return new Tricycle();
    }

    @Override
    public Unicycle getUnicycle() {
        System.out.println("do some for un");
        return new Unicycle();
    }

    @Override
    public Bicycle getBicycle() {
        System.out.println("do some for bi");
        return new Bicycle();
    }
}
