package com.Excutor.ExcutorType;

import com.XML.XMLConverToObject.Time;
import com.sweng.exer3.Person;
import org.junit.Test;

import java.util.concurrent.*;

/**
 * @Description:
 * @Author: swengcode
 * @Date: 2020/6/1017:04
 */
public class ExcutorTypeTest {


    /*
        newCachedThreadPool : 可缓冲的线程，没有限制的线程，若存在空闲线程，则会复用，不会创建新线程。
        从当前数可知
     */

    class testRunnable implements Runnable{

        private Integer id;
        private Person person;

        public testRunnable(Integer id,Person person) {
            this.person = person;
            this.id = id;
        }

        @Override
        public void run() {

            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            person.setName("run_"+id);

            System.out.println(person);
        }
    }

    class MyTestThread implements Runnable{

        private String ThreadName;

        private Object waitObject;

        public MyTestThread(String name,Object object) {
            this.ThreadName = name;
            this.waitObject = object;
        }

        @Override
        public void run() {

            synchronized (waitObject) { //执行wait方法必须去使用 synchronize关键字配合使用
                try {
                    waitObject.wait(); //线程会进入 阻塞状态，但是会释放掉waitObjec锁。 因为会释放掉，执行的每个线程都能拿到锁，然后阻塞主、
                } catch (InterruptedException e) {

                }
                System.out.println("Thread Name is " + ThreadName);
            }
        }
    }

    //测试使用notif
    @Test
    public void testNotify() throws InterruptedException {

        final Object o = new Object();
        for (int i = 0; i < 5; i++) {
            Thread thread = new Thread(new MyTestThread("Thread" + i,o));
            thread.start();
        }



        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (o) {   //因为前面的wait方法会释放锁，这里拿到锁或唤醒他们。 同理notifyAll也需要上锁。
                    System.out.println("notify one");
                    o.notifyAll();  //notify是唤醒其中一个等待池中的线程
                }

            }
        }).start();


        Thread.sleep(3000);

    }


    //测试线程的join方法
    @Test
    public void testJoin() throws InterruptedException {


        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("222222222222");
            }
        });

        thread.start();
        thread.join(); //在主线程去调用thread的join方法，主线程去回去阻塞，等待thread执行完成

        System.out.println("111111111111111");
        //Thread.sleep(4000);
    }

    @Test
    public void runnableTest() throws InterruptedException {

        ExecutorService executorService = Executors.newCachedThreadPool();
        String name = new String();
        name = "init";
        Person person = new Person();
        person.setName(name);

        for(int i = 0; i < 10 ; i++){
            executorService.execute(new testRunnable(i,person));
        }

        System.out.println(person);
        Thread.sleep(2000);
        System.out.println("---end---");
        System.out.println(person);


        Thread.sleep(3000);
        System.out.println("---end---");
        System.out.println(person);


    }

    @Test
    public void excutCacheThread() throws InterruptedException {

        ExecutorService executorService = Executors.newCachedThreadPool();

        for (int i = 0; i < 10; i++) {
            final int flag = i;
            try {
                Thread.sleep(flag*1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    try {
                        System.out.println("线程名称:"+this.toString());
                        int threadCount = ((ThreadPoolExecutor)executorService).getActiveCount();
                        System.out.println("当前线程数threadCount===="+threadCount);

                        System.out.println("执行线程-"+flag);
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }
            });

        }

        Thread.sleep(100000);

    }

    /*
         newFixedThreadPool： 固定线程数线程，固定线程数量，超过的自动进入线程队列。
     */
    @Test
    public void executorFixedThread() throws InterruptedException {

        ExecutorService executorService = Executors.newFixedThreadPool(5);

        for (int i = 0; i < 10; i++) {
            final int flag = i;
            executorService.execute(new Runnable() {
                @Override
                public void run() {

                    System.out.println("线程-"+flag);
                    int threadCount = ((ThreadPoolExecutor)executorService).getActiveCount();
                    System.out.println("当前线程数threadCount===="+threadCount);
                    try {
                        Thread.sleep(10000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }
            });
        }


        Thread.sleep(100000);
    }

    /*
        newSingleThread:单线程，最大只有一个线程，超过的进程进入等待队列，保证先进先出。

     */
    @Test
    public void executorSingleThread() throws InterruptedException {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        for (int i = 0; i < 10; i++) {
            final int flag = i;
            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println("单线程i："+flag);
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
        Thread.sleep(10000);
    }

    /*
        executor.scheduleAtFixRate(Runnable run,long initDelay,long period,TimeUnit time)
        initDelay 第二个参数：第一个任务启动延迟的时间

        period 第三个参数： 周期启动时间，本次任务启动后，下个任务启动时间。

        如果本任务未完成，下个任务还是会等待改任务完成后再启动

     */

    @Test
    public void executorScheduledExecutor() throws InterruptedException {

        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(1);

        //scheduledExecutorService.scheduleWithFixedDelay()

        scheduledExecutorService.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                System.out.println("delay 1 seconds, and excute every 3 seconds");
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, 1, 1, TimeUnit.SECONDS);
        /*
        Runnable asyncRunner = new Runnable() {
            public void run() {
                System.out.println("delay 1");
            }
        };
        scheduledExecutorService.schedule(asyncRunner,1000, TimeUnit.MILLISECONDS);
*/

        Thread.sleep(20000);
    }





    /*
        executor.scheduleWithFixedDelay(Runnable run,long initDelay,long period,TimeUnit time)
        initDelay 第二个参数：第一个任务启动延迟的时间

        period 第三个参数： 周期启动时间，本次任务结束后，下个任务启动的时间。

        这与上面的不太相同。
     */

    @Test
    public void executorScheduleExecutor2() throws InterruptedException {

        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(5);
        scheduledExecutorService.scheduleWithFixedDelay(new Runnable() {
            @Override
            public void run() {
                System.out.println("delay 1 seconds, and excute every 3 seconds");
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, 0, 5, TimeUnit.SECONDS);

        Thread.sleep(20000);

    }

}
