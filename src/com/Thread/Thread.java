package com.Thread;

import org.junit.Test;

/**
 * @Description:
 * @Author: swengcode
 * @Date: 2020/11/2018:51
 */
public class Thread {


    private Method method;


    public static void main(String[] args) {


        Method method = new Method();

        new Runnable() {
            @Override
            public void run() {

                System.out.println("使用外部类");
                method.uesMethod();
            }
        }.run();



    }

    @Test
    public void test(){

        String format = "(%s)";
        String test = "xxx";
        String format1 = String.format(format, test);
        System.out.println(format1);

    }

}
