package com.Exception.LostThrow;

/**
 * @Description:
 * @Author: swengcode
 * @Date: 2019/11/2019:04
 */
public class Test {

    public void testThrow() throws Exception{
        System.out.println("...");
    }

    /*重载不能通过，异常来判断，必须通过方法名称和方法的参数来判断重载。
    public void testThrow(){

    }

     */

    public static void main(String[] args) {

        try {


        try{
         throw new RuntimeException();
        }
        finally {
            return;
        }
        }catch (Exception e){
            System.out.println("1"+e);

        }

    }

}
