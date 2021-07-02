package com.DeepDesignPattern.AdapterPattern.ClassAdapter;

/**
 * @Description:
 * @Author: swengcode
 * @Date: 2019/12/1911:25
 */
public class Adapter extends Voliate220V implements Voliate5V {


    @Override
    public int outPutVoliate5V() {
        Integer src  = null;
        Integer dst = null;

        src = outPutVoliate220V();

        if(src!=null){

            dst = src/44;
            return dst;
        }

        return 0;
    }

}
