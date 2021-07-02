package com.Container.List;

import com.sweng.exer3.Person;
import org.junit.Test;
import org.junit.platform.commons.util.StringUtils;

import java.util.*;

/**
 * @Description:
 * @Author: swengcode
 * @Date: 2019/11/1319:34
 */
public class TestListAPI {


    @Test
    public void test222() throws Exception {

        for (int i = 0; i < 5; i++) {


            System.out.println("test id : "+i);

            String s = String.valueOf(new Date().getTime());
            System.out.println("new data:"+s);

            try {
                if (i == 2)
                    throw new Exception();
            }catch (Exception e){
                System.out.println("catch error");
                //return;
            }

            System.out.println("end id:"+i);
        }


    }

    @Test
    public void test_3(){

        Student student1 = new Student(11, "3");

        Student student2 = new Student(10, "2");

        Student student3 = new Student(8, "1");

        List<Student> Student = Arrays.asList(student1, student2, student3);

        Integer i = 1;
        System.out.println(i.equals("1"));
        System.out.println(i.equals(1));

        ArrayList<String> strings = new ArrayList<>();
        strings.add("1");
        strings.add("2");
        //System.out.println(StringUtils);


    }

    @Test
    public void LinkedList(){

        LinkedList<String> x = null;
        x.add("dd");

        Person person = new Person();
        person.setName("222");

        LinkedList<Person> strings = new LinkedList<Person>();
        strings.add(null);
        strings.add(null);
        strings.add(null);
        //System.out.println(strings.get());
        Person person1 = new Person();
        person1.setAge(2);
        //strings.add(0, person1);
        strings.set(0, person1);
        System.out.println(strings.size());
        System.out.println(strings.get(0));
        System.out.println(strings.get(1));
        System.out.println(strings.get(2));


    }


    @Test
    public void test_2(){

        ArrayList<String> s1 = new ArrayList<>();
        s1.add("1");
        s1.add("1");
        s1.add("2");
        s1.add("3");
        Iterator<String> ite = s1.iterator();
        while (ite.hasNext()) {
            ite.next();
        }
        ite.remove();

        for(String t:s1){
            System.out.println("test1"+t);
        }

        ArrayList<String> s2 = new ArrayList<>();
        s2.add("1");
        s2.add("1");
        s2.add("2");
        s2.add("3");

        ArrayList<String> stest = new ArrayList<>();
        stest.add("10");
        stest.add("11");

        s2.addAll(stest);
        for(String s :s2){
            System.out.println("add"+s);
        }


        for (int i = 0; i < s2.size(); i++) {

            if(s2.get(i).equals("1")){
                s2.remove(i);
            }

        }
        for(String t2:s2){
            System.out.println("test2:"+t2);
        }


        ArrayList<String> s3 = new ArrayList<>();
        s3.add("1");
        s3.add("1");
        s3.add("2");
        s3.add("3");

        Iterator<String> iterator = s3.iterator();
        while (iterator.hasNext()){

            if(iterator.next().equals("1"))
            {
                iterator.remove();
            }

        }
        for(String t3:s3){
            System.out.println("test3:"+t3);
        }

    }

    @Test
    public void test_1(){

        String[] s = new String[1];
        Object[] o = new Object[1];

        System.out.println("String[]:"+s);
        System.out.println("Object[]:"+o);

        ArrayList<String> strings = new ArrayList<>();
        strings.add("1");
        strings.add("2");
        strings.add("3");
        strings.add("4");
        String[] strings2 = strings.toArray(new String[10]);
        System.out.println(strings2.length);
        for(String x:strings2){
            System.out.println("t:"+x);
        }


        //String[] objects = (String[])strings.toArray();

        //System.out.println(new String[10].length);
        String[] s1 = {"1","2","3","4","5","6","7"};
        System.out.println(s1.length);
        System.out.println("size:"+strings.size());

        String[] strings1 = strings.toArray(new String[0]);

        System.out.println("moren:"+strings1.length);
        for(String t:s1){
            System.out.println(t);
        }




    }


    public static void main(String[] args) {

        List<Integer> integerList = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            integerList.add(i);
        }
        integerList.add(3, 10);

        List<Integer> subList = integerList.subList(2,integerList.size());

        ArrayList<Integer> integers = new ArrayList<>();

        System.out.println("integerList"+integerList);
        System.out.println("subList"+subList);

        //添加
        integerList.add(10);
        System.out.println("---");
        System.out.println("integerList"+integerList);
        System.out.println("subList"+subList);

    }

}
