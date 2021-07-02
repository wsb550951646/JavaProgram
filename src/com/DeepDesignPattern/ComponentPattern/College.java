package com.DeepDesignPattern.ComponentPattern;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description:
 * @Author: swengcode
 * @Date: 2019/12/2311:18
 */
public class College extends AbstractComponent {

    List<AbstractComponent> departments = new ArrayList<>();

    public College(String name, String des) {
        super(name, des);
    }

    @Override
    public void add(AbstractComponent college) {
        departments.add(college);
    }

    @Override
    public void remove(String name) {

        AbstractComponent removeKey = null;
        if(name != null && !name.isEmpty()){
            for (AbstractComponent department:departments){
                if(department.getName().equals(name)) {
                    removeKey = department;
                    break;
                }
            }

        }
        if (removeKey!=null)
            departments.remove(removeKey);

    }

    @Override
    public void removeAll() {

        departments.removeAll(departments);

    }

    @Override
    public void display() {

        System.out.println("-------"+getName()+"-"+getDes()+"-------");
        for (AbstractComponent component:departments){
            component.display();
        }


    }







}
