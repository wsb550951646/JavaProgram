package com.sweng.TypeThink.ParentType;

import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Description:
 * @Author: swengcode
 * @Date: 2021/1/1419:38
 */
public class TotalTest {

    private Parent parent;

    public TotalTest() {
    }

    public TotalTest(Parent parent) {
        this.parent = parent;
    }

    public Parent getParent() {
        return parent;
    }

    public void setParent(Parent parent) {
        this.parent = parent;
    }

    @Override
    public String toString() {
        return "TotalTest{" +
                "parent=" + parent +
                '}';
    }


    public static void main(String[] args) throws CloneNotSupportedException, ParseException {

        Date date = new Date(0);
        System.out.println(date);

        SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");

        Date date2 = dateformat.parse("");
        System.out.println(date2);

        String x = "12345";
        String y = "12345/78";
        String substring = y.substring(x.length() + 1);
        System.out.println(substring);

/*
        cloneTest cloneTest1 = new cloneTest();
        cloneTest result = null;

        result = (cloneTest)cloneTest1.clone();
        System.out.println(result);

        result.setId(1);

        result = (cloneTest)cloneTest1.clone();
        System.out.println(result);
        System.out.println(result.getId());

        */

        TotalTest totalTest = new TotalTest();

        Son sondd = new Son(1, "SONDD");
        Parent parent = new Parent();

        Son clonesondd = (Son)sondd.clone();

        totalTest.setParent(clonesondd);

        System.out.println(totalTest);

        System.out.println("------");
        Son son2 = (Son)totalTest.getParent();
        System.out.println(son2);




        Parent parent1 = totalTest.getParent();


        System.out.println(parent1);

        TotalTest totalTest1 = new TotalTest();
        totalTest1.setParent(parent1);

        System.out.println(totalTest1);
    }

}
