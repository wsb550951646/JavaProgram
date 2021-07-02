package com.Exception.Log.HelloLog;

import org.apache.log4j.Logger;

/**
 * @Description:
 * @Author: swengcode
 * @Date: 2019/11/2115:42
 */
public class HelloLog {

    public static Logger logger =Logger.getLogger(HelloLog.class);

    public static void main(String[] args) {


        //log4j 放在类路径下 log4j.properties
        logger.info("1");
        logger.error("1");
        logger.trace("1");
        logger.debug("1");
    }

}
