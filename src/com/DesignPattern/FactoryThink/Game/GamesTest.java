package com.DesignPattern.FactoryThink.Game;

/**
 * @Description:
 * @Author: swengcode
 * @Date: 2019/9/2514:56
 */
public class GamesTest {

    /*
        工厂模式强调： A和B之间的关系仅仅是A创建B或者A使用B，而不能者都是。

        工厂模式好处： 防止用来实例化的一个类的数据和代码在多个类中到处都是，可以将有关创建的知识搬到一个工厂类
        若果代码散落在每个创建对象客户类中，出现混乱。而客户类无需承担创建工作，只需要引用工厂创建即可。

        还有一个好处： 客户端只能从传入不同的对象去调用不同的构造函数创建对象，但是大家也许不了解构造对象参数所造成
        的产品差异，但是如果都封装在工厂类中，可以提供一系列名字不同的工厂方法，每个工厂方法对应一个构造函数。这样客户
        端可以更容易的理解。


     */


    public static  void play(Factory factory){

        Game checkerGame = factory.assemblyCheckerGame();
        checkerGame.move();

        Game chessGame = factory.assemblyChessGame();
        chessGame.move();

    }

    public static void main(String[] args) {

        Factory factory = new FactoryImpl();

        play(factory);


    }

}
