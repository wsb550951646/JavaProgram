package com.DeepDesignPattern.AdapterPattern.InterfaceAdapter;

import com.DeepDesignPattern.AdapterPattern.ClassAdapter.Voliate5V;

/**
 * @Description:
 * @Author: swengcode
 * @Date: 2019/12/1911:27
 */
public class Phone {

    public void charge(Voliate5V voliate5V){

        int i = voliate5V.outPutVoliate5V();
        if(i == 5){
            System.out.println("电压为5，可以充电");
        }else
            System.out.println("电压错误，不可充电");

    }

}
