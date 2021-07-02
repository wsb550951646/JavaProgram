package com.DeepDesignPattern.AdapterPattern.InterfaceAdapter;

import com.DeepDesignPattern.AdapterPattern.ClassAdapter.Voliate5V;

/**
 * @Description:
 * @Author: swengcode
 * @Date: 2019/12/1911:25
 */
public class Adapter implements Voliate5V {

    private Voliate220V voliate220V;

    public Adapter(Voliate220V voliate220V) {
        this.voliate220V = voliate220V;
    }

    @Override
    public int outPutVoliate5V() {
        Integer src  = null;
        Integer dst = null;

        src = voliate220V.outPutVoliate220V();

        if(src!=null){
            dst = src/44;
            return dst;
        }

        return 0;
    }

}
