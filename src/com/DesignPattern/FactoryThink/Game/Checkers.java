package com.DesignPattern.FactoryThink.Game;

/**
 * @Description:
 * @Author: swengcode
 * @Date: 2019/9/2514:46
 */
public class Checkers implements Game {

    @Override
    public boolean move() {
        System.out.println("Checkers is complicated");
        return false;
    }
}
