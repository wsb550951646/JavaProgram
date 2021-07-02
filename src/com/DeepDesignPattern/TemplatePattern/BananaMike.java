package com.DeepDesignPattern.TemplatePattern;

/**
 * @Description:
 * @Author: swengcode
 * @Date: 2019/12/249:50
 */
public class BananaMike extends AbstractMike {
    @Override
    protected void prepare() {
        System.out.println("准备好香蕉");
    }
}
