package com.Generice.GenericeInterface.ErasePack.EraseLearn;

/**
 * @Description:
 * @Author: swengcode
 * @Date: 2019/10/2318:57
 */
public class ClassTypeCapture<T> {

    private Class<T> type;

    private T t;

    public ClassTypeCapture(Class<T> type) {
        this.type = type;
    }

    public boolean isInstance(Object object){
        return type.isInstance(object);
    }

    public boolean falseInstance(Object object){
      // return object instanceof T;  任何类型信息，都无法工作
        return false;
    }

    public T asFactroy(Class<T> type){

        T t = null;
        try {
            t = type.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return t;

    }


    /*
        擦除的补偿。
        运行时需要知道确切类型信息的操作都无法工作
        arg instanceof T  表示：

        所以：通过引入类型的标签对擦除进行补偿



        因为在泛型中无法创建一个 new T() 部分因为擦除

        所有： 通过使用类型标签的newInstance()的方法



     */
    public static void main(String[] args) {
     //  ClassTypeCapture<House> house = new ClassTypeCapture<House>(House.class);
        //  house.isInstance(new House()); // true

     //   ClassTypeCapture<Bike> bike = new ClassTypeCapture<Bike>(Bike.class);
     //   bike.isInstance(new House()); // false


    }
}
