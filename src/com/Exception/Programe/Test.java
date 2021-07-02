package com.Exception.Programe;

/**
 * @Description:
 * @Author: swengcode
 * @Date: 2019/11/2017:08
 */
public class Test {

    public static void main(String[] args) {

        Test t = new Test();
        try {
            t.f();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("---");
            System.out.println(e.getMessage());
        }

    }



    public void f() throws MyExceptionTwo {

        try {
            g();
        }catch (Exception e){
            System.out.println("f() 中又抛出一个异常");
            throw new MyExceptionTwo("抛出错误",e);
        }

    }

    public void g() throws MyException {

        System.out.println("This is g throw exception");
        throw new MyException();

    }

}
