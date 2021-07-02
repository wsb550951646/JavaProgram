package com.DeepDesignPattern.TemplatePattern;

/**
 * @Description:
 * @Author: swengcode
 * @Date: 2019/12/249:50
 */
public class Client {

    public static void main(String[] args) {

        AbstractMike bananaMike = new BananaMike();
        bananaMike.make();

        System.out.println("---");

        AbstractMike pennetMike = new PennetMike();
        pennetMike.make();

        System.out.println("---");

        AbstractMike pureMike = new PureMike();
        pureMike.make();

    }

}
