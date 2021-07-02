package com.DeepDesignPattern.AdapterPattern.SimpleSpringMVC;

/**
 * @Description:
 * @Author: swengcode
 * @Date: 2019/12/1915:55
 */
//这里有问题，Handler是没有共同的基类的，这里只是简化操作了
public interface Handler {

}

class SimpleHandler implements Handler{

    public void doSimpleHandler(){
        System.out.println("do simpleHandler");
    }

}

class HttpHandler implements Handler{

    public void doHttpHandler(){
        System.out.println("do HttpHandler");
    }


}

class AnnotationHandler implements Handler{

    public void doAnnotationHandler (){
        System.out.println("do AnnotationHandler");
    }

}
