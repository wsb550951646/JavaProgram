package com.Excutor.FutureTask;

import java.util.concurrent.*;

/**
 * @Description:
 * @Author: swengcode
 * @Date: 2020/12/115:04
 */
public class FutureTaskDemo {


    public static Future<?> doWork(){
        Future<?> future = null;

        final ExecutorService executor = Executors.newCachedThreadPool();

        Callable<?> callable = new Callable<Exception>() {
            @Override
            public Exception call() throws Exception {
                Exception ret = null;
                if(executor.isShutdown()){
                    return null;
                }
                int result = 0;
                try{
                    for(int i=0; i < 5000;i++){
                        result = i+result;
                    }
                    Thread.sleep(15000);
                }catch (Exception e){
                    ret = e;
                    System.out.println("error in call");
                }

                return ret;
            }
        };

        future = executor.submit(callable);
        return future;
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException, TimeoutException {


/*
        ExecutorService executorService = Executors.newCachedThreadPool();

        Callable<Long> callable = new Callable<Long>() {

            @Override
            public Long call() throws Exception {
                long result = 0;
                for(int i=0; i < 5000;i++){
                    result = i+result;
                }
                Thread.sleep(5000);
                return result;
            }
        };


        FutureTask<Long> futureTask = new FutureTask<Long>(callable);
        new Thread(futureTask).start();
*/

    try {

        Future<?> future = doWork();

        System.out.println("主线程执行了");

        future.get(10000,TimeUnit.MILLISECONDS);

        System.out.println("线程结束了");

    }catch (TimeoutException e){
        System.out.println("chaoshi");
    }

    }

}
