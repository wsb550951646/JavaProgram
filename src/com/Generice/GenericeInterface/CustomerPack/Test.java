package com.Generice.GenericeInterface.CustomerPack;

import java.util.*;

/**
 * @Description:
 * @Author: swengcode
 * @Date: 2019/10/2114:46
 */
public class Test {


    public static void server(Customer customer,Teller teller){

        System.out.println(teller.toString()+"server--"+customer.toString());
    }

    public static void main(String[] args) {

        /*
        List<Customer> customerList = new ArrayList<>();
        Generators.fill(Customer.generator(),customerList ,5 );

        List<Teller> tellerList = new LinkedList<>();
        Generators.fill(Teller.Generator(), tellerList, 10);

        for(Customer c:customerList){

            FileToExcelTest.server(c, tellerList.get(new Random().nextInt(tellerList.size())));

        }
        */
        int[][] arr = {{12,58},{12,23,45},{0}};

        for(int i=0; i<arr.length; i++){
            for(int j=0;j<arr[i].length;j++){
                System.out.println(i+"-"+j+":"+arr[i][j]+" ");
            }
            System.out.println(" ");
        }



    }
}
