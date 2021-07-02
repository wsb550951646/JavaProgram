package com.Enum;

/**
 * @Description:
 * @Author: swengcode
 * @Date: 2021/1/1918:31
 */
public class Test {


    public static void main(String[] args) {

        System.out.println("默认的属性name:"+Task.DOWNLOADED.name());
        System.out.println("默认属性ordinal:"+Task.DOWNLOADED.ordinal());
        System.out.println("自定义属性id"+Task.DOWNLOADED.getId());

        TotalTask totalTask = new TotalTask(Task.DOWNLOADED);
        System.out.println(totalTask);
        System.out.println(totalTask.getStatus());

    }

}
