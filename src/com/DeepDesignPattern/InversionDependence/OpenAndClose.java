package com.DeepDesignPattern.InversionDependence;

/**
 * @Description:
 * @Author: swengcode
 * @Date: 2019/12/418:41
 */
public class OpenAndClose implements IOpenAndClose {

    //参数传递方法
    @Override
    public void open(ITV itv) {
        itv.play();
    }


    /*
    构造器传递方法
    ITV itv;

    public void OpenAndClose(ITV itv){

        this.itv = itv;

    }

    public void open(){
        itv.play();
    }


     */


    /*
    setter传递方法
    ITV itv

    public void setter(ITV itv){

        this.itv = itv;

    }


    pulic void open(){

        itv.play();

    }


     */

}
