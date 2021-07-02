package com.DeepDesignPattern.ComponentPattern;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description:
 * @Author: swengcode
 * @Date: 2019/12/2311:06
 */
public class University extends AbstractComponent {

    private List<AbstractComponent> colleges = new ArrayList<>();

    public University(String name, String des) {
        super(name, des);
    }

    @Override
    public void add(AbstractComponent college) {
        colleges.add(college);
    }

    @Override
    public void remove(String name) {

        AbstractComponent removeKey = null;
        if(name != null && !name.isEmpty()){
            for (AbstractComponent college:colleges){
                if(college.getName().equals(name)) {
                    removeKey = college;
                    break;
                }
            }

        }
        if (removeKey!=null)
        colleges.remove(removeKey);


    }

    @Override
    public void removeAll() {

        colleges.removeAll(colleges);

    }

    @Override
    public void display() {
        System.out.println("-------"+getName()+"-"+getDes()+"-------");
        for (AbstractComponent component:colleges){
            component.display();
        }
    }
}
