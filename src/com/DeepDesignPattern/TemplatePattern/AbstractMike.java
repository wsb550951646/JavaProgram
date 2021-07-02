package com.DeepDesignPattern.TemplatePattern;

/**
 * @Description:
 * @Author: swengcode
 * @Date: 2019/12/249:45
 */
public abstract class AbstractMike {

    protected final void make(){
        prepare();
        if(wantAdd())
        add();
        pending();
        cooking();
        finish();
    }

    protected abstract void prepare();

    protected void add(){
        System.out.println("添加豆浆");
    }

    protected void pending(){
        System.out.println("捣碎中");
    }

    protected void cooking(){
        System.out.println("烹饪中");
    }

    protected void finish(){
        System.out.println("完成制作");
    }

    protected boolean wantAdd(){
        return true;
    }


}
