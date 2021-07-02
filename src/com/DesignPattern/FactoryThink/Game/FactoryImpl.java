package com.DesignPattern.FactoryThink.Game;

/**
 * @Description:
 * @Author: swengcode
 * @Date: 2019/9/2514:51
 */
public class FactoryImpl implements Factory {


    @Override
    public Game getChessGame() {
        return new Chess();
    }

    @Override
    public Game getCheckerGame() {
        return new Checkers();
    }

    @Override
    public Game assemblyCheckerGame() {

        Checkers checkers = new Checkers();
        System.out.println("assembly Checker Game");
        return checkers;
    }

    @Override
    public Game assemblyChessGame() {

        Chess chess = new Chess();
        System.out.println("assembly chess Game");
        return chess;
    }


}
