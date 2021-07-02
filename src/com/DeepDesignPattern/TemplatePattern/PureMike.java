package com.DeepDesignPattern.TemplatePattern;

/**
 * @Description:
 * @Author: swengcode
 * @Date: 2019/12/249:55
 */
public class PureMike extends AbstractMike {
    @Override
    protected void prepare() {
        System.out.println("准备好纯牛奶");
    }

    @Override
    protected boolean wantAdd() {
        return false;
    }
}
