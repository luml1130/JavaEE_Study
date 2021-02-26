package com.luml.mybatis1;/**
 * @author luml
 * @description
 * @date 2020/8/16
 */

import org.apache.log4j.Logger;

/**
 * @author luml
 * @description
 * @date 2020/8/16
 */
public class Log4jTest {

    private static Logger logger = Logger.getLogger(Log4jTest.class.getName());

    public static void main(String[] args) {
        //Logger logger=Logger.getLogger(Log4jTest.class);
        logger.fatal("致命错误");
        logger.error("普通错误");
        logger.warn("警告");
        logger.info("普通信息");
        logger.debug("调试信息");
        logger.trace("普通信息");
    }
}
