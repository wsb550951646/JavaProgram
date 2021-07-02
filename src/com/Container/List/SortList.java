package com.Container.List;

import java.util.*;

/**
 * @Description:
 * @Author: swengcode
 * @Date: 2019/11/516:18
 */
public class SortList {

    public static void main(String[] args) {


        Student student1 = new Student(12, "1");
        Student student2 = new Student(15, "2");
        Student student3 = new Student(16, "3");

        List<Student> studentList = new ArrayList<>();
        studentList.add(student3);
        studentList.add(student2);
        studentList.add(student1);

        for(Student s:studentList){
            System.out.println(s.getAge()+"--"+s.getName());
        }
        System.out.println("--");
        Collections.sort(studentList, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {

                //按照年龄排序 升序   大于则1
                if(o1.getAge() > o2.getAge())
                    return 1;
                if(o1.getAge() == o2.getAge())
                    return 0;

                return -1;
            }
        });

        for(Student s:studentList){
            System.out.println(s.getAge()+"--"+s.getName());
        }



    }
}
