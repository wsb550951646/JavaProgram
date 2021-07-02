package com.DesignPattern.AdaptPattern.Charge;

/**
 * @Description:
 * @Author: swengcode
 * @Date: 2019/10/815:20
 */
public class AdaptPart implements IAndroidPart {

    private IApplePart applePart;

    public AdaptPart(IApplePart applePart) {
        this.applePart = applePart;
    }

    @Override
    public void androidPart() {
       applePart.ApplePart();
    }
}
