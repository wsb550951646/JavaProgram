package com.Generice.GenericeInterface.ErasePack;

/**
 * @Description:
 * @Author: swengcode
 * @Date: 2019/10/2314:27
 */
public class ManiF<T extends HasF> {

    private  T object;

    public ManiF(T object) {
        this.object = object;
    }

    public void mainFiu(){

        object.f();

    }



}
