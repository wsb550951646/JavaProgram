package com.sweng.TypeThink.RegisteredFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @Description:
 * @Author: swengcode
 * @Date: 2019/9/2910:03
 */
public class FactoryAssemble {

    static List<Factory<? extends FactoryAssemble>> factoryList = new ArrayList<>();

    public String toString(){
        return getClass().getSimpleName();
    }

    static {

        factoryList.add(new Sofa.Factory());
        factoryList.add(new Stool.Factory());
        factoryList.add(new Table.Factory());

    }

    public static Random random = new Random(50);
    public static FactoryAssemble RandCreate(){

        int n = random.nextInt(factoryList.size());
        return factoryList.get(n).Create();

    }

    public static void main(String[] args) {

        for (int i = 0; i < 5 ; i++) {

            System.out.println(FactoryAssemble.RandCreate());
        }

    }

}
