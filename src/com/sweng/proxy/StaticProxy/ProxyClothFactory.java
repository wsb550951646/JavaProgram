package com.sweng.proxy.StaticProxy;

import com.sweng.proxy.StaticProxy.ClothFactory;

/**
 * @Description:
 * @Author: swengcode
 * @Date: 2019/4/1813:36
 */
public class ProxyClothFactory implements ClothFactory {

    private ClothFactory clothFactory = null;

    public ProxyClothFactory(ClothFactory clothFactory) {
        this.clothFactory = clothFactory;
    }

    @Override
    public void produceCloth() {

        System.out.println("工厂工作之前");

        clothFactory.produceCloth();

        System.out.println("工厂工作之后");



    }
}
