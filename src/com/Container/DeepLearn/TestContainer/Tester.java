package com.Container.DeepLearn.TestContainer;

import java.util.List;

/**
 * @Description:
 * @Author: swengcode
 * @Date: 2019/12/213:53
 */
public class Tester<C> {

    public static TestParam[] defaultParam =  TestParam.array(10,5000,100,5000,1000,5000,10000,5000);
    private List<Test<C>> tests;
    protected C container;
    private TestParam[] params = defaultParam;
    private String headline = "";

    public Tester(List<Test<C>> tests, C cotainer) {
        this.tests = tests;
        container = cotainer;
        if(cotainer!=null)
            headline = cotainer.getClass().getSimpleName();
    }

    public Tester(List<Test<C>> tests, C container, TestParam[] params){
        this(tests,container);
        this.params = params;
    }

    protected C initialize(int size){return container;}

    public static <C> void run(List<Test<C>> tests,C container){
        new Tester(tests, container).timeTest();
    }

    public static <C> void run(List<Test<C>> tests,C container, TestParam[] params){
        new Tester(tests, container,params).timeTest();
    }

    private void headTitle(){

        for(Test<C> test:tests){
            System.out.print(test.getName()+"-----");
        }

    }

    protected void timeTest(){

        System.out.println("----"+headline+"----");
        headTitle();
        System.out.println("");
        for(TestParam tp : params){

            for(Test<C> test:tests){
                C cotainer = initialize(tp.size);
                long start = System.nanoTime();
                int response = test.test(cotainer, tp);
                long duration = System.nanoTime() - start;
                long time = duration / response;
                System.out.print(time+"-----");
            }
            System.out.println("");
        }



    }





}
