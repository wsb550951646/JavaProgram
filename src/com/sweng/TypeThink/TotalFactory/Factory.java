package com.sweng.TypeThink.TotalFactory;

import javafx.scene.control.Tab;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @Description:
 * @Author: swengcode
 * @Date: 2019/9/2910:22
 */
public class Factory {

    public static List<Class<? extends furniture>> toalFactory = new ArrayList<>();

    public static Random rand = new Random(29);
    static {

        toalFactory.add(Sofa.class);
        toalFactory.add(Table.class);
        toalFactory.add(Stool.class);

    }

    public static furniture createRandom(){

        int n = rand.nextInt(toalFactory.size());
        try {
            return toalFactory.get(n).newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }


        return null;
    }



    public static void main(String[] args) {


        for (int i = 0; i < 12; i++) {

            System.out.println(createRandom());

        }


    }


}
