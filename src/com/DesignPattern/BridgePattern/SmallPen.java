package com.DesignPattern.BridgePattern;

/**
 * @Description:
 * @Author: swengcode
 * @Date: 2019/10/814:09
 */
public class SmallPen extends AbstractSize{
    @Override
    public void size() {
        System.out.println("小型号的毛笔");
    }

    public void useColor(){

        this.getColor().color();

    }
}
