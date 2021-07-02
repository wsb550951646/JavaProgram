package com.InnerClass;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description:
 * @Author: swengcode
 * @Date: 2019/11/514:15
 */
public class InnerClassTest {

    public static void main(String[] args) {

        final String a = "1";
        String b = "2";

        InnerClassTest innerClassTest = new InnerClassTest();
        innerClassTest.test(b);
    }

    public void test(final String a){

        final List<String>  aList = new ArrayList<>();

        ClassAB ab = new ClassAB() {
            @Override
            public void m() {

                int x = a.hashCode();
                System.out.println(x);
                aList.add(a);


            }
        };

        ab.m();
        System.out.println(aList);


    }




}
