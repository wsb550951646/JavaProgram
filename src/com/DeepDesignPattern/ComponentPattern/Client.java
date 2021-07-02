package com.DeepDesignPattern.ComponentPattern;

/**
 * @Description:
 * @Author: swengcode
 * @Date: 2019/12/2311:25
 */
public class Client {

    public static void main(String[] args) {

        University university1 = new University("清华大学", "985一流大学");


        College college = new College("计算机科学与技术","热门专业");
        College college2 = new College("会计", "金融热门专业");


        Department department = new Department("学生会", "为学生服务部门");
        Department department1 = new Department("团委", "团组织分支");


        college.add(department);
        college.add(department1);

        college2.add(department);
        college2.add(department1);

        university1.add(college);
        university1.add(college2);

        university1.display();

    }

}
