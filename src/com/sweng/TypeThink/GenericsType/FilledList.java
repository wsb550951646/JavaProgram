package com.sweng.TypeThink.GenericsType;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description:
 * @Author: swengcode
 * @Date: 2019/9/2615:07
 */
public class FilledList<T> {

    private Class<T> type;

    public FilledList(Class<T> type) {
        this.type = type;
    }


    public  List<T> createList(int Element) throws IllegalAccessException, InstantiationException {

        List<T> result = new ArrayList<>();

        for (int i = 0; i < Element; i++) {
            result.add(type.newInstance());
        }

        return result;
    }


    public static void main(String[] args) throws InstantiationException, IllegalAccessException {

        FilledList<CounteInteger> filledList = new FilledList<>(CounteInteger.class);

        List<CounteInteger> list = filledList.createList(13);

        System.out.println(list);

        FilledList<CounteDouble> filledList2 = new FilledList<>(CounteDouble.class);

        List<CounteDouble> list2 = filledList2.createList(13);

        System.out.println(list2);

        FilledList<CountePerson> filledList3 = new FilledList<>(CountePerson.class);

        List<CountePerson> list3 = filledList3.createList(13);

        System.out.println(list3);


    }

}
