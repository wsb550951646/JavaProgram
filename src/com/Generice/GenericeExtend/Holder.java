package com.Generice.GenericeExtend;

import com.DesignPattern.StrategyPattern.Market.Banan;

/**
 * @Description:
 * @Author: swengcode
 * @Date: 2019/10/259:15
 */
public class Holder<T> {

    private T value;

    public Holder() {
    }

    public Holder(T t) {
        value = t;
    }

    public void set(T val) {
        value = val;
    }

    public T get() {
        return value;
    }

    public boolean equals(Object object) {
        return value.equals(object);
    }

    public void getType() {

        System.out.println(value.getClass().getTypeName());

    }

    public static void main(String[] args) {

        //1.不带extend super
        Apple apple = new Apple();
        Orange orange = new Orange();
        Fruit fruit = new Fruit();
        BaseFruit baseFruit = new BaseFruit();

        Holder<Fruit> holder = new Holder<>(apple);

        System.out.println("---- apple ----");
        boolean equals = holder.equals(apple);
        System.out.println(equals);
        holder.getType();

        System.out.println("---- orange ----");
        holder.set(orange);
        System.out.println(holder.equals(orange));
        holder.getType();


        //2.带上Extend的泛型

          /*
            缺点：无法去添加类进入该参数，因为Holder类可以创建Apple Orange Fruit 等，只能保证是在[?,Fruit]范围，

            但是添加进去的无法确定具体是什么类型，而无法保证安全性

            优点：可以用Fruit的类去接受返回值，因为范围在[?,Fruit]中，返回的类型都可以Fruit去接收

            并且可以接收子类的去赋值
         */
        System.out.println("---- Extends ----");
        Holder<? extends Fruit> holderextens = new Holder<Apple>();
        Holder<? extends Fruit> holderextens2 = new Holder<Orange>();
        Holder<? extends Fruit> holderextens3 = new Holder<Fruit>();
        //Holder<? extends Fruit>   = new Holder<BaseFruit>(); 编译失败 <? extends Fruit> 创建接收只能Fruit和其子类。


        //holderextens.set(Apple);  扩展了 ？ extend Fruit 无法再set
        //holderextens.set(Orange);
        holderextens = holder;
        holderextens.getType();
        System.out.println(holderextens.equals(orange));

        holderextens2 = new Holder<Orange>(orange);
        holderextens2.getType();   //type=>Orange

        holderextens3 = new Holder<Orange>(orange);
        holderextens3.getType();

        Fruit fruit1 = holderextens2.get();
        System.out.println(fruit1.getClass().getTypeName());

        baseFruit = holderextens.get();
        System.out.println(baseFruit.getClass().getTypeName());


        //3.带上Super的泛型
        /*
            缺点：使用get只能用Object来接收，获取去执行强制转换，会丢失类型信息。（Type）

            优点：可以去set添加类（Fruit 的子类和 Object 类型） 但是编译器并不知道是哪个超类，因此不能添加任何特定的超类（BaseFruit）


         */

        System.out.println("---- Super ----");
        Holder<? super Fruit> holderSuper = new Holder<Fruit>();
        Holder<? super Fruit> holderSuper1 = new Holder<Object>();
        Holder<? super Fruit> holderSuper3 = new Holder<BaseFruit>();
        //Holder<? super Fruit> holderSuper4 = new Holder<Apple>()；  编译报错  <？ super Fruit> 创建的时候只接收Fruit和父类  此当成方法的参数原来相同

        //holderSuper3.set(baseFruit);  //编译报错
        //holderSuper3.getType();


        holderSuper.set(fruit);
        holderSuper.set(apple);     //都可以编译通过
        holderSuper.set(orange);
        holderSuper.getType();

        //get 无法通过编译，在接收类型非Object
        //Fruit fruit2 = holderSuper.get();
        Object object = holderSuper.get();
        System.out.println(object.getClass().getTypeName());



        Fruit fruit2 = (Fruit)holderSuper.get();
        System.out.println(fruit2.getClass().getTypeName());

    }
}
