package com.DeepDesignPattern.CommandPattern.example;
import com.XML.XMLConverToObject.XmlUtil;

import java.util.Arrays;

/**
 * @Description:
 * @Author: swengcode
 * @Date: 2019/12/2416:51
 */
public class Client {

    private static final String PACK_NAME = "com.DeepDesignPattern.CommandPattern.example.";

    /*
        前言： 如果我们使用不同的命令，调用不同的方法，出现很多if-else分支，不利于维护。

        可以使用命令模式，将接口与实现分离开来，实现解耦。

     */

    public static void main(String[] args) {

        DispatchCommand dispatchCommand = new DispatchCommand();
        dispatchCommand.handler(PACK_NAME+"Print", "123");
        dispatchCommand.handler(PACK_NAME+"NoCommand", "1234");


        System.out.println("--使用xml下发任务--");

        XmlUtil xmlUtil = new XmlUtil();
        CommandConfigure commandConfigure = xmlUtil.FileConverToObject(CommandConfigure.class, "3.txt");

        if(commandConfigure != null) {
            for (CommandConfigure.Clazz clazz : commandConfigure.getClasses()) {
                    if(clazz!=null){
                            switch (clazz.getArgs().size()) {
                                case 0:
                                    dispatchCommand.handler(clazz.getPackName() + clazz.getClassName());
                                    break;
                                case 1:
                                    dispatchCommand.handler(clazz.getPackName() + clazz.getClassName(),clazz.getArgs().get(0));
                                    break;
                                case 2:
                                    dispatchCommand.handler(clazz.getPackName()+clazz.getClassName(), clazz.getArgs().get(0),clazz.getArgs().get(1));
                            }

                    }
                }
            }


    }

}
