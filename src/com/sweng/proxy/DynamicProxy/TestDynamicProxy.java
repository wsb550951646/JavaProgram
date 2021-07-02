package com.sweng.proxy.DynamicProxy;

import com.sweng.proxy.StaticProxy.ClothFactory;
import com.sweng.proxy.StaticProxy.Nike;
import org.junit.Test;

/**
 * @Description:
 * @Author: swengcode
 * @Date: 2019/4/1814:11
 */
public class TestDynamicProxy {

    @Test
    public void test(){

        SuperMan superMan = new SuperMan();

        DynamicProxy dynamicProxy = new DynamicProxy();

        // Human proxyInstance = (Human)ProxyFactory.getProxyInstance(superMan);
        Human bind = (Human)dynamicProxy.bind(superMan);

        System.out.println(bind.believe());

        bind.sing("..");



        Nike nike = new Nike();

        ClothFactory proxyInstance1 = (ClothFactory) ProxyFactory.getProxyInstance(nike);

        proxyInstance1.produceCloth();

    }

}
