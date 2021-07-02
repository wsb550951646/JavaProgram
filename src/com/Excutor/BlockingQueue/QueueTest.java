package com.Excutor.BlockingQueue;

import com.DeepDesignPattern.Clone.Person;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @Description:
 * @Author: swengcode
 * @Date: 2020/10/2816:18
 */
public class QueueTest {

    public LinkedBlockingQueue<String> testQueues = new LinkedBlockingQueue<>(5);

    public static void main(String[] args) {

         LinkedBlockingQueue<HashMap<Integer, String>> queue = new LinkedBlockingQueue<>();


        HashMap<Integer, String> map = new HashMap<>();
        map.put(1, "test1");
        boolean add = queue.add(map);
        if(add){
            String s = map.get(1);
            map.put(1, "test222");
        }
        HashMap<Integer, String> poll = queue.poll();
        System.out.println(poll.get(1));



    }

    public class consumerdd implements Runnable{

        public consumerdd() {
        }

        @Override
        public void run() {
            while (true){
                String str = testQueues.poll();
                System.out.println("current str : "+str);
                System.out.println("当前队列长:"+testQueues.size());

                if(testQueues.size()==0){
                    for (int i = 0; i < 5; i++) {
                        testQueues.add(i+"");
                    }
                }

            }
        }
    }

    @Test
    public void test() throws InterruptedException {

        ExecutorService executorService = Executors.newFixedThreadPool(2);
        executorService.execute(new consumerdd());

        String s = "";
        s.toUpperCase();

        Person person = new Person();
        person.setPersonName("1");
        person.setAge("1");
        person.setId(1);
        HashMap<Person, String> personStringHashMap = new HashMap<>();
        personStringHashMap.put(person, "1");

        Person person1 = new Person();
        person1.setId(1);
        person1.setAge("2");
        person1.setPersonName("2");
        personStringHashMap.put(person1, "2");
        for (Map.Entry<Person,String> m : personStringHashMap.entrySet()){
            System.out.println("key id-"+m.getKey().getId()+" age:"+m.getKey().getAge()+" name:"+m.getKey().getPersonName());
            System.out.println("val:"+m.getValue());
        }

        Thread.sleep(1000000);


    }

}
