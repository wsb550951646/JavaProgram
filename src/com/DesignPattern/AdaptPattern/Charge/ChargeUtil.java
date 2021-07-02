package com.DesignPattern.AdaptPattern.Charge;

/**
 * @Description:
 * @Author: swengcode
 * @Date: 2019/10/815:16
 */
public class ChargeUtil {

    private IAndroidPart androidPart;

    public ChargeUtil(IAndroidPart androidPart) {
        this.androidPart = androidPart;
    }

    public void useCharge(){

        androidPart.androidPart();

    }


}
