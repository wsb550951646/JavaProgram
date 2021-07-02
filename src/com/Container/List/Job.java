package com.Container.List;

/**
 * @Description:
 * @Author: swengcode
 * @Date: 2019/11/513:36
 */
public abstract class Job implements Runnable {


    public abstract void doJob();

    private Integer id = 0;

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void showjob(){

        System.out.println( this.getId());

    }

    @Override
    public void run() {

    }


}
