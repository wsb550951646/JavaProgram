package com.DeepDesignPattern.singleton;

/**
 * @Description:
 * @Author: swengcode
 * @Date: 2019/12/1311:21
 */
public class SingletonTotal {


    static class SingletonHungerOne{

        //防止外部调用new创建对象  | 静态内部类也可以实现，即有懒加载的模式，还能保障线程的安全
        private SingletonHungerOne(){

        }

        static final SingletonHungerOne instance = new SingletonHungerOne();

        public SingletonHungerOne getInstance(){
            return instance;
        }


    }


    static class SingletonHungerTwo {

        static SingletonHungerTwo instance;

        static {
            instance = new SingletonHungerTwo();
        }

        private SingletonHungerTwo() {

        }

        public SingletonHungerTwo getInstance() {
            return instance;
        }
    }

    static class SingletonLazyOne{

         static SingletonLazyOne instance = null;

         private SingletonLazyOne(){

         }

         public SingletonLazyOne getInstance(){

             if(instance==null)
                 return new SingletonLazyOne();
             else
                 return instance;
         }


    }

    static class SingletonLazyTwo {

        static SingletonLazyTwo instace = null;

        private SingletonLazyTwo() {

        }

        public synchronized SingletonLazyTwo getInstance() {

            if (instace == null)
                return new SingletonLazyTwo();
            else
                return instace;

        }

    }

    public static void main(String[] args) {


        Singleton instance = Singleton.INSTANCE;
        Singleton instance2 = Singleton.INSTANCE;
        if(instance==instance2)
            System.out.println("YES");
        instance.sayOk();

    }

}

//枚举也能产生单例模式
enum Singleton{

    INSTANCE; //属性

    public void sayOk(){
        System.out.println("ok!");
    }


}
