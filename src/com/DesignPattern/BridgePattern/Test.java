package com.DesignPattern.BridgePattern;

/**
 * @Description:
 * @Author: swengcode
 * @Date: 2019/10/813:51
 */
public class Test {

    /*
        桥梁模式：

        首先先理解一下，桥接模式。假如我们需要3个型号的画笔，能够绘制12中不同的颜色，如果使用蜡笔，需要准备3*12 = 36支，
        但是如果使用毛笔的话，只需要提供12个颜料盘 3+12 = 15支。如果增加一个型号的蜡笔，就要增加12支对应型号的颜色蜡笔，
        为什么会出现这种情况呢？

        在蜡笔中，颜色和型号两个不同变化维度融合在一起了，无论对颜色还是型号的扩展都会影响另一个维度；但是在毛笔中，颜色和
        型号实现分离。我们可以认为蜡笔中的颜色和型号之间存在强烈的耦合，毛笔将两者解耦了。



     */

    public static void main(String[] args) {


        BigPen bigPen = new BigPen();
        BuleColor buleColor = new BuleColor();
        bigPen.setColor(buleColor);
        bigPen.size();
        bigPen.useColor();

        System.out.println("-----更换颜色------");
        bigPen.setColor(new RedColor());
        bigPen.useColor();
        bigPen.size();

        System.out.println("----更换型号------");
        SmallPen smallPen = new SmallPen();
        smallPen.setColor(new RedColor());
        smallPen.useColor();
        smallPen.size();




    }


}
