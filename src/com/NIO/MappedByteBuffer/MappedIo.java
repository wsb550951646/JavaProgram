package com.NIO.MappedByteBuffer;

import java.io.IOException;

/**
 * @Description:
 * @Author: swengcode
 * @Date: 2019/11/817:48
 */
public class MappedIo {

    private abstract static class Tester{

        private String name;
        public Tester(String name){this.name = name;}
        public void runTest() throws IOException {
            System.out.println(name+" :");

            long l = System.nanoTime();
            test();
            double dur = System.nanoTime() - l;
            System.out.format("%.2f\n",dur/1.0e9);

        }

        public abstract void test() throws IOException;


    }

    private static Tester[] testers = {
            new Tester("Stream Write"){


                @Override
                public void test() throws IOException {

                }
            }

    };



}
