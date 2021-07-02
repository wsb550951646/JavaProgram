package com.Generice.GenericeMethod;

/**
 * @Description:
 * @Author: swengcode
 * @Date: 2019/10/2113:42
 */
public class GenericeMethod<T> {

    public <E> void generice(E e){

        System.out.println(e.getClass().getName());

    }


    // 若不定义类型参数列表， 类必须是泛型方法才可以使用泛型  GenericeMethod<T>!!
    public void generice2(T t){
        System.out.println(t.getClass().getName());
    }

    public static void main(String[] args) {

        GenericeMethod<String> genericeMethod = new GenericeMethod<>();
        genericeMethod.generice(123);

        //泛型类中定义了T为String， 方法使用T时也要与创建的时候保持一致，使用T类型。否则报错
        //genericeMethod.generice2(1234);


    }

}
