package com.DesignPattern.AdaptPattern.Charge;

/**
 * @Description:
 * @Author: swengcode
 * @Date: 2019/10/815:19
 */
public class Test {

    /*
        适配器模式的根本：把一个类的接口变成客户端所期待的另一个接口，使得原本因为接口不同的两个类不匹配而无法工作，而在一起工作。

        1.为什么要继承安卓的接口，而不是内部类
        因为继承安卓接口，可以把适配器对象当做安卓接口传入到chargUtil的充电工具类中，可以去使用chargeUtil的方法，达到复用的效果。

        2.


     */


    public static void main(String[] args) {

        IAndroidPart androidPart = new AndroidPartImp();
        ChargeUtil chargeUtil = new ChargeUtil(androidPart);
        chargeUtil.useCharge();

        System.out.println("适配器---android给apple充电");

        IApplePart applePart = new ApplePartImp();
        AdaptPart adaptPart = new AdaptPart(applePart);
        ChargeUtil chargeUtil1 = new ChargeUtil(adaptPart);
        chargeUtil1.useCharge();


    }

}
