package com.Exception.Throw;

import org.junit.Test;

import java.util.ArrayList;

/**
 * @Description:
 * @Author: swengcode
 * @Date: 2019/11/1811:24
 */
public class TestThrow {


    @Test
    public void test(){

        ArrayList<Double> ddd = new ArrayList<>();

        ddd.add(1.0);
        ddd.add(2.0);
        ddd.add(3.0);
        ddd.add(4.0);


        for (int i = 0; i < ddd.size(); i++) {
            ArrayList temp1 = null;
            //temp1中所有的元素都是Double
            Double s = new Double(0.0);
            try {
                if (i != 2)
                    s = (Double) (temp1.get(0));
                else
                    temp1 = (ArrayList) (temp1.get(0)); //exception
            }
            catch (ClassCastException ex) {
                System.out.println("catch ClassCastException");
            }
            System.out.println("T is " + s.doubleValue());
        }

    }

    public static void main(String[] args) throws Exception {

        ArrayList<String> strings = new ArrayList<>();

        strings.add("1");
        strings.add("2");
        strings.add("3");
        strings.add("4");

        for(String s:strings){
            try {
                if (s.equals("2")) {
                    Exception exception = new Exception();
                    throw exception;
                }
                System.out.println(s);
            }catch (Exception e){
                System.out.println("catch Exception");
                throw new Exception("test");
            }
        }


    }
}
