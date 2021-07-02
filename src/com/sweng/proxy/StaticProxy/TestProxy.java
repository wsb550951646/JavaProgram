package com.sweng.proxy.StaticProxy;

import org.junit.Test;

/**
 * @Description:
 * @Author: swengcode
 * @Date: 2019/4/1813:41
 */
public class TestProxy {


    /*
    静态代理类使用：

    ClothFactory：接口
    ProxyClothFactory：代理类，继承ClothFactory接口
    Nike：被代理类，继承ClothFactory接口
     */
    @Test
    public void test1(){

        ClothFactory Nike = new Nike();

        ProxyClothFactory proxyClothFactory = new ProxyClothFactory(Nike);

        proxyClothFactory.produceCloth();

    }
}
