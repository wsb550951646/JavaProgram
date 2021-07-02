package com.DesignPattern.DependentInversionPattern.Drive;

/**
 * @Description:
 * @Author: swengcode
 * @Date: 2019/9/2916:13
 */
public class BMW implements ICar {
    @Override
    public void run() {

        System.out.println("宝马车启动");
    }
}
