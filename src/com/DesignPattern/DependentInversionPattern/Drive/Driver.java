package com.DesignPattern.DependentInversionPattern.Drive;

/**
 * @Description:
 * @Author: swengcode
 * @Date: 2019/9/2916:13
 */
public class Driver implements IDriver {
    @Override
    public void driver(ICar car) {
        System.out.println("司机市内正常驾驶 ");
        car.run();
    }
}
