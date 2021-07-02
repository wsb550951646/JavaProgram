package com.DeepDesignPattern.CommandPattern.example;

/**
 * @Description:
 * @Author: swengcode
 * @Date: 2019/12/2416:55
 */
public class NoCommand implements  ICommand{
    @Override
    public void execute(String... o) {
        System.out.println("没有操作");
    }
}
