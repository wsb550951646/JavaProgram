package com.DeepDesignPattern.CommandPattern.example;

/**
 * @Description:
 * @Author: swengcode
 * @Date: 2019/12/2514:10
 */
public class PrintTwo implements ICommand {
    @Override
    public void execute(String... o) {

        System.out.println("打印操作 传入的参数为"+o[0].toString()+" 和 "+o[1].toString());

    }
}
