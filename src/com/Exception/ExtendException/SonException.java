package com.Exception.ExtendException;

/**
 * @Description:
 * @Author: swengcode
 * @Date: 2019/11/2019:22
 */
public class SonException extends FatherException{
    @Override
    public void FatherMehthod() {

        System.out.println("ok no extends FatherException");
    }
}
