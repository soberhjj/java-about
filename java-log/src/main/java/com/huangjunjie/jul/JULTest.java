package com.huangjunjie.jul;

import org.junit.Test;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @Author: huangJunJie  2021-02-22 18:09
 */
public class JULTest {

    //JUL入门案例
    @Test
    public void testQuick() {
        //1.获取日志记录器对象。每个日志记录器都需要有一个唯一标识，通常以当前类的全限定类名来命名
        Logger logger = Logger.getLogger("com.huangjunjie.jul.JULTest");

        //2.输出日志记录，下面以输出info级别的日志为例，注意日志记录的默认输出位置是控制台
        logger.info("hello jul");

        //用通用方法来输出日志记录
        logger.log(Level.INFO, "hello jul");

        //通过占位符方式输出变量值
        String name = "zhangSan";
        int age = 24;
        logger.log(Level.INFO, "the name is {0},the age is {1}", new Object[]{name, age});
    }



    /**
     *     JUL中的日志级别
     *     java.util.logging.Level定义了7个日志级别：级别由高到低按顺序如下
     *     SEVERE（最高级别）、WARNING、INFO（默认级别）、CONFIG、FINE、FINER、FINEST（最低值）
     *     还有2个特殊的级别：
     *     OFF(关闭所有级别的日志记录)、ALL(启动所有级别的日志记录)
     *
     *     注意：只有日志级别高于或者等于当前日志系统所设置的日志级别的日志记录才会被输出。
     *     比如日志系统设置日志级别为INFO，那么只有INFO以及比INFO级别更高的WARNING和SEVERE这三个级别的日志记录才会被输出。
     */
    @Test
    public void testLogLevel(){
        Logger logger = Logger.getLogger("com.huangjunjie.jul.JULTest");

        //输出不同级别的日志
        logger.severe("severe");
        logger.warning("warning");
        logger.info("info");
        //注意由于jul默认的日志级别是INFO，jul本质就是java内置的一个日志系统，通过jul的相关API，我们可以和jul这个日志系统进行交互
        //上面的logger对象就是我们访问jul这个日志系统的入口
        //由于以下这些日志记录级别均小于jul日志系统默认的日志级别(即INFO)，固它们最终都不会被输出
        logger.config("config");
        logger.fine("fine");
        logger.finer("finer");
        logger.finest("finest");

        System.out.println("----------------------------");
    }

    //

}
