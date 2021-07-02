package com.Generice.GenericeInterface.ErasePack;

/**
 * @Description:
 * @Author: swengcode
 * @Date: 2019/10/2314:23
 */
public class Manip<T> {

    private T object;

    public Manip(T t) {

        object = t;
    }

    public void mainpiu(){

        //object.f();
    }


    //尽管Mainp中拥有了HasF的f()  但是在mainpiu方法中任然不能够调用HasF类的f()方法
    //在MainF中<X extends Hasf> mainFiu中方法中可以使用HasF类中f（）方法
    public static void main(String[] args) {

        HasF hasF = new HasF();
        Manip<HasF> mainp = new Manip<>(hasF);
        mainp.mainpiu();

        ManiF<HasF> mainF = new ManiF<>(hasF);
        mainF.mainFiu();

    }


}
