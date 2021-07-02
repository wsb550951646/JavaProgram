package com.DeepDesignPattern.ProxyPattern.Dynamic;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @Description:
 * @Author: swengcode
 * @Date: 2019/12/2316:44
 */
public class DynamicFactory {

    private Object target;

    public DynamicFactory(Object target) {
        this.target = target;
    }

    public Object getInstance(){

        return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(),
                new InvocationHandler() {

                    //这里增加一个思考问题，为什么这里有一个proxy参数，作用是什么
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {


                        if(method.getName().equals("Teach")) {
                            System.out.println("JDK动态代理开始");
                            //注意这里的method.invoke(Obj obj, Object[] args) 方法执行 obj表示被代理的类，args方法的参数，返回为方法的返回值
                            Object result = method.invoke(target, args);
                            System.out.println("JDK动态代理结束");
                            return result;
                        }
                        else if(method.getName().equals("dupMethod")){

                            /*
                                如果要想返回 本类对象，this却不是该代理类，可以使用proxy对象

                                1.这里有个细节，若果这里
                                    Object invoke = method.invoke(target, args); return invoke;
                                    返回的是方法的返回值（ITeach），继续调用则不是proxy代理对象了

                                2.但是这里使用

                                    method.invoke(target,args); return proxy;
                                    返回是一个代理对象，再次调用的话也还是会执行代理方法。

                             */
                            System.out.println("这里展示了proxy使用");
                            Object invoke = method.invoke(target, args);
                            //method.invoke(target,args);
                            System.out.println("结束咯");
                            return invoke;
                            //return proxy;

                        }
                        return null;
                    }
                });
    }



}
