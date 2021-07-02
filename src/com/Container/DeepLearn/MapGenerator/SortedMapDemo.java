package com.Container.DeepLearn.MapGenerator;

import com.Container.DeepLearn.AbstractMap.CountingMapData;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.SortedMap;
import java.util.TreeMap;

/**
 * @Description:
 * @Author: swengcode
 * @Date: 2019/11/2715:24
 */
public class SortedMapDemo {

    public static void main(String[] args) {

        //SortedMap的唯一实现类TreeMap
        SortedMap<Integer,String> sortedMap = new TreeMap<Integer, String>(new CountingMapData(10));

        System.out.println(sortedMap);

        //fistMap
        Integer low = sortedMap.firstKey();

        //high
        Integer high = sortedMap.lastKey();

        System.out.println(low);
        System.out.println(high);

        SortedMap<Integer, String> sortedMap1 = sortedMap.subMap(3, 6); //[3,6)
        System.out.println(sortedMap1);

        System.out.println(sortedMap.headMap(5)); //小于5的所有Map

        System.out.println(sortedMap.tailMap(5)); //大于5的所有Map





    }


}
