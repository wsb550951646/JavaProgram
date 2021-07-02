package com.DeepDesignPattern.CommandPattern.example;

/**
 * @Description:
 * @Author: swengcode
 * @Date: 2019/12/2416:54
 */
public class Print implements ICommand{
    @Override
    public void execute(String... o) {

        System.out.println("执行了打印操作 传入的参数为:"+o[0].toString());

    }
}
