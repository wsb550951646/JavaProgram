package com.Exception.Throw;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

/**
 * @Description:
 * @Author: swengcode
 * @Date: 2019/11/2013:53
 */
public class TestChainThrow {

    public static void main(String[] args) {

        System.out.println("请输入2个加数");
        int result;
        try
        {
            result = add();
            System.out.println("结果:"+result);
        } catch (Exception e){
            e.printStackTrace();
        }

    }

    //执行加法计算
    private static int add() throws Exception
    {
        int result;
        try {
            List<Integer> nums =getInputNumbers();
            result = nums.get(0)  + nums.get(1);
        }catch(InputMismatchException immExp){
            throw new Exception("计算失败",immExp);  /////////////////////////////链化:以一个异常对象为参数构造新的异常对象。
        }
        return  result;
    }

    //获取输入的2个整数返回
    private static List<Integer> getInputNumbers()
    {
        List<Integer> nums = new ArrayList<>();
        Scanner scan = new Scanner(System.in);
        try {
            int num1 = scan.nextInt();
            int num2 = scan.nextInt();
            nums.add(new Integer(num1));
            nums.add(new Integer(num2));
        }catch(InputMismatchException immExp){
            throw immExp;
        }finally {
            scan.close();
        }
        return nums;
    }





}
