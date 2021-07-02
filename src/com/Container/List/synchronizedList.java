package com.Container.List;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @Description:
 * @Author: swengcode
 * @Date: 2019/11/417:00
 */
public class synchronizedList {

    public List<Job> jobList = new ArrayList<>();

    public List<Job> getJobList() {
        return jobList;
    }

    public synchronizedList() {

    }

    public static void main(String[] args) {

        final List<String> partList =  Collections.synchronizedList(new ArrayList<String>());

        synchronizedList synchroniz  = new synchronizedList();

        for (int i = 0; i < 5; i++) {

            final int par = i;
            System.out.println("begin"+par);
            synchroniz.addJob(new Job(){
                @Override
                public void doJob() {

                    setId(par);
                    partList.add(par+"-index");
                    System.out.println("add"+par);


                }
            });

        }

        for (Job j:synchroniz.getJobList()){
            j.doJob();
        }



        System.out.println(partList);




    }

    public synchronized void addJob(Job job){

        jobList.add(job);
    }


}
