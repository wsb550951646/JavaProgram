package com.DeepDesignPattern.CommandPattern.example;


/**
 * @Description:
 * @Author: swengcode
 * @Date: 2019/12/2416:58
 */
public class DispatchCommand {

    public void handler(String methodName,String... obj){

        try {
            ICommand command = (ICommand)Class.forName(methodName).newInstance();
            command.execute(obj);
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }


}
