package com.Container.List;

import java.util.*;

/**
 * @Description:
 * @Author: swengcode
 * @Date: 2019/11/610:39
 */
public class sortMap {

    public static void main(String[] args) {

        Object one = 100000;
        Object tww = 233333;
        Integer x1 = (Integer)one;
        System.out.println(x1);

        Student student1 = new Student(12, "1");
        Student student2 = new Student(15, "2");
        Student student3 = new Student(16, "3");

        HashMap<Integer, Student> map = new HashMap<>();
        map.put(3, student3);//16
        map.put(2, student2);//15
        map.put(1, student1);//12

        for(Map.Entry<Integer,Student> entry:map.entrySet()){

            System.out.println(entry.getKey()+"--"+entry.getValue().getAge());

        }

        //对Value中的 Student中的age进行排序
        List<Map.Entry<Integer, Student>> entries = new ArrayList<>(map.entrySet());

        Collections.sort(entries, new Comparator<Map.Entry<Integer, Student>>() {
            @Override
            public int compare(Map.Entry<Integer, Student> o1, Map.Entry<Integer, Student> o2) {

                if(o1.getValue().getAge() > o2.getValue().getAge())
                    return -1;
                if(o1.getValue().getAge() == o2.getValue().getAge())
                    return 0;

                return 1;
            }
        });

        for(Map.Entry<Integer,Student> e:entries){
            System.out.println(e.getKey()+"---"+e.getValue().getAge());
        }

        //对key排序 简单

        Set<Integer> integers = map.keySet();

        Object[] objects = integers.toArray();

        Arrays.sort(objects);

        for(Object o:objects){
            System.out.println(o+"----"+map.get(o).getAge());
        }


    }


}
