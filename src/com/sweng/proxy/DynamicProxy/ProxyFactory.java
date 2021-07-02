package com.sweng.proxy.DynamicProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @Description:
 * @Author: swengcode
 * @Date: 2019/4/1814:04
 */
public class ProxyFactory {

    public Object object = null;

    public ProxyFactory(Object object) {
        this.object = object;
    }

    public static Object getProxyInstance(Object object){

        MyInvocation myInvocation = new MyInvocation();

        myInvocation.bind(object);


        //Proxy.newProxyInstance 中会去调用myInvocation（继承了InvocationHandler）中的 invoke方法
        return Proxy.newProxyInstance(object.getClass().getClassLoader(), object.getClass().getInterfaces(), myInvocation);

    }


}

class MyInvocation implements InvocationHandler {

    public Object object;

    public void bind(Object object){
        this.object = object;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        System.out.println("111");

        // 此method.invoke 是一个被代理类执行的方法  其中（result）返回值是被代理类方法的返回值。
        Object result = method.invoke(object, args);

        System.out.println("222");

        return result;
    }



}
