package com.DesignPattern.FactoryThink.Program;

/**
 * @Description:
 * @Author: swengcode
 * @Date: 2019/9/2515:24
 */
public interface Factory {

    Cycle getTricycle();
    Cycle getUnicycle();
    Cycle getBicycle();

}
