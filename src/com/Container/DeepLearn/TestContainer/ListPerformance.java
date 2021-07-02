package com.Container.DeepLearn.TestContainer;

import jdk.nashorn.internal.ir.LiteralNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

/**
 * @Description:
 * @Author: swengcode
 * @Date: 2019/12/214:39
 */
public class ListPerformance {

    static Random random = new Random();
    static List<Test<List<Integer>>> tests = new ArrayList<>();
    static List<Test<List<Integer>>> qTests = new LinkedList<>();

    static {

        tests.add(new Test<List<Integer>>("add") {
            @Override
            public int test(List<Integer> contain, TestParam pt) {

                for (int i = 0; i < pt.looper; i++) {

                    contain.clear();
                    for (int j = 0; j < pt.size; j++) {

                        contain.add(j);

                    }
                }

                return pt.looper * pt.size;
            }
        });

        tests.add(new Test<List<Integer>>("get") {
            @Override
            public int test(List<Integer> contain, TestParam pt) {

                int loops = pt.looper * 1000;

                int size = contain.size();

                for (int i = 0; i < loops; i++) {

                    contain.get(random.nextInt(size));

                }

                return loops;
            }
        });

        tests.add(new Test<List<Integer>>("set") {
            @Override
            public int test(List<Integer> contain, TestParam pt) {
                int loops = pt.looper * 1000;

                int size = contain.size();

                for (int i = 0; i < loops; i++) {

                    contain.set(random.nextInt(size),11);

                }

                return loops;
            }
        });

        tests.add(new Test<List<Integer>>("insert") {
            @Override
            public int test(List<Integer> contain, TestParam pt) {

                int loops = pt.looper;

                for (int i = 0; i < loops; i++) {

                    contain.add(7, 11);

                }

                return loops;

            }
        });

        tests.add(new Test<List<Integer>>("remove") {
            @Override
            public int test(List<Integer> contain, TestParam pt) {

                int loops = pt.looper;
                int size = pt.size;

                for (int i = 0; i < loops; i++) {

                    contain.clear();
                    contain.addAll(new CouterInterList(size));

                    while ( contain.size() > 5 )
                        contain.remove(5);

                }


                return loops * size;
            }
        });

    }

    static class ListenTester extends Tester<List<Integer>>{


        public ListenTester(List<Test<List<Integer>>> tests, List<Integer> cotainer) {
            super(tests, cotainer);
        }

        public ListenTester(List<Test<List<Integer>>> tests, List<Integer> container, TestParam[] params) {
            super(tests, container, params);
        }

        @Override
        protected  List<Integer> initialize(int size) {

            container.clear();
            container.addAll(new CouterInterList(size));
            return container;
        }

        public static void run(List<Integer> container,List<Test<List<Integer>>> tests){
           new ListenTester(tests, container).timeTest();
        }

        public static void run(List<Integer> cotainer,List<Test<List<Integer>>> tests,TestParam[] params){
            new ListenTester(tests, cotainer, params);
        }



    }

    public static void main(String[] args) {



        ListenTester.run(new ArrayList<Integer>(),tests);

        ListenTester.run(new LinkedList<Integer>(), tests);


    }


}
