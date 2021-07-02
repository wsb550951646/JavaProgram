package com.DeepDesignPattern.AdapterPattern.SimpleSpringMVC;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description:
 * @Author: swengcode
 * @Date: 2019/12/1915:52
 */
public class DispatchService {

    private List<HandlerAdapter> adapterList = new ArrayList<>();

    public DispatchService() {
        adapterList.add(new SimpleHandlerAdapter());
        adapterList.add(new HttpHandlerAdapter());
        adapterList.add(new AnnotationHandlerAdapter());
    }

    public void doDispatch(){

        SimpleHandler Handler = new SimpleHandler();
        //HttpHandler Handler = new HttpHandler();
        //AnnotationHandler Handler = new AnnotationHandler();

        HandlerAdapter adapter = null;

        for(HandlerAdapter h:adapterList){
            if(h.supports(Handler)){
                adapter = h;
                break;
            }
        }

        if(adapter!=null)
        adapter.handle(Handler);



    }

    public static void main(String[] args) {


        DispatchService ds = new DispatchService();
        ds.doDispatch();
    }

}
