package com.sweng.proxy.DynamicProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @Description:
 * @Author: swengcode
 * @Date: 2019/9/2917:08
 */
public class DynamicProxy implements InvocationHandler {

    public Object target;

    public DynamicProxy() {

    }

    public Object bind(Object target){

        this.target = target;

        return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        System.out.println("DynamicProxy Begin");

        Object invoke = method.invoke(target, args);

        //Object invoke = method.invoke(proxy, args);

        System.out.println("proxy ="+proxy.getClass()+" name="+proxy.getClass().getSimpleName());

        System.out.println("DynamicProxy End");

        return invoke;
    }
}
