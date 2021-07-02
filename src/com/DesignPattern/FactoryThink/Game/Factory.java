package com.DesignPattern.FactoryThink.Game;

/**
 * @Description:
 * @Author: swengcode
 * @Date: 2019/9/2514:49
 */
public interface Factory {

    Game getChessGame();
    Game getCheckerGame();
    Game assemblyCheckerGame();
    Game assemblyChessGame();

}
