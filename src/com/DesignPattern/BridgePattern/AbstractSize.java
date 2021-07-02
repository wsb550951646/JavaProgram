package com.DesignPattern.BridgePattern;

/**
 * @Description:
 * @Author: swengcode
 * @Date: 2019/10/814:04
 */
public abstract class AbstractSize {

    private IColor color;

    public void setColor(IColor color) {
        this.color = color;
    }

    public IColor getColor() {
        return color;
    }

    public abstract void size();


}
