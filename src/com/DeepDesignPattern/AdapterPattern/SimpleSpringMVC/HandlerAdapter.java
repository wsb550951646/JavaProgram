package com.DeepDesignPattern.AdapterPattern.SimpleSpringMVC;

/**
 * @Description:
 * @Author: swengcode
 * @Date: 2019/12/1915:53
 */
public interface HandlerAdapter {

    public boolean supports(Object object);

    public void handle(Object object);

}

class SimpleHandlerAdapter implements HandlerAdapter{

    @Override
    public boolean supports(Object object) {

        return (object instanceof SimpleHandler);
    }

    @Override
    public void handle(Object object) {

        if(object instanceof SimpleHandler) {
            SimpleHandler simpleHandler = (SimpleHandler) object;
            simpleHandler.doSimpleHandler();
        }

    }
}

class HttpHandlerAdapter implements HandlerAdapter{

    @Override
    public boolean supports(Object object) {
        return (object instanceof HttpHandler);
    }

    @Override
    public void handle(Object object) {

        if(object instanceof HttpHandler) {
            HttpHandler HttpHandler = (HttpHandler) object;
            HttpHandler.doHttpHandler();
        }

    }
}

class AnnotationHandlerAdapter implements HandlerAdapter{

    @Override
    public boolean supports(Object object) {
        return (object instanceof AnnotationHandler);
    }

    @Override
    public void handle(Object object) {

        if(object instanceof  AnnotationHandler) {
            AnnotationHandler  AnnotationHandler = ( AnnotationHandler) object;
            AnnotationHandler.doAnnotationHandler();
        }

    }
}
