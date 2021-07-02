package com.Container.Hash.HashMap;

import java.util.HashMap;

/**
 * @Description:
 * @Author: swengcode
 * @Date: 2019/11/2516:51
 */
public class Test {

    public static void main(String[] args) {

        HashMap<String, String> stringStringHashMap = new HashMap<>();

        for (int i = 0; i < 20; i++) {
            stringStringHashMap.put("o"+i, "v"+i);
        }

        for(HashMap.Entry<String,String> t:stringStringHashMap.entrySet()){
            System.out.println("key-"+t.getKey()+" val-"+t.getValue());

        }

        System.out.println();


    }
}
