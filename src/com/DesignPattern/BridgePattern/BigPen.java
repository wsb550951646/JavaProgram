package com.DesignPattern.BridgePattern;

/**
 * @Description:
 * @Author: swengcode
 * @Date: 2019/10/814:07
 */
public class BigPen extends AbstractSize {
    @Override
    public void size() {
        System.out.println("大型号的毛笔");
    }

    public void useColor(){

        this.getColor().color();

    }

}
