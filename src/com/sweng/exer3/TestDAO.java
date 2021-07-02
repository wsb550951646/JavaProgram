package com.sweng.exer3;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description:
 * @Author: swengcode
 * @Date: 2019/4/1710:34
 */
public class TestDAO {
    public static void main(String[] args) {

        DAO<Person> dao = new DAO<>();
        List<Person> ts = new ArrayList<Person>();

        dao.save("1001", new Person("zhou",23,"男","杭州"));
        dao.save("1002", new Person("Tom",13,"男","北京"));
        dao.save("1003", new Person("Jerry",23,"男","杭州"));

        dao.update("1003", new Person("Jerry111",23,"男","杭州"));
        dao.delete("1003");

        ts = dao.list();
        System.out.println(ts);

    }
}
