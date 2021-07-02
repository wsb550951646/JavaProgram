package com.DeepDesignPattern.AdapterPattern.ClassAdapter;

/**
 * @Description:
 * @Author: swengcode
 * @Date: 2019/12/1911:27
 */
public class Client {

    public static void main(String[] args) {

        Phone phone = new Phone();
        phone.charge(new Adapter());


    }

}
