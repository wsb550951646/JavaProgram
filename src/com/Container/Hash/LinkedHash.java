package com.Container.Hash;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @Description:
 * @Author: swengcode
 * @Date: 2019/10/2413:28
 */
public class LinkedHash {

    public static void main(String[] args) {

        Map<String,String> linkedHashMap = new LinkedHashMap<>();

        linkedHashMap.put("a", "1");
        linkedHashMap.put("b", "2");
        linkedHashMap.put("c", "3");

        Map<String,String> linkedHashMap2 = new LinkedHashMap<>();

        linkedHashMap2.put("a", "2");
        linkedHashMap2.put("b", "3");
        linkedHashMap2.put("c", "4");
        linkedHashMap2.put("d", "5");

        linkedHashMap.putAll(linkedHashMap2);

        System.out.println(linkedHashMap);


    }

}
