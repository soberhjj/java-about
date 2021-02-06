package com.huangjunjie.exception;

/**
 * @author huangJunJie 2021-02-06-12:36
 *
 *          程序运行Error举例
 */
public class ErrorDemo1 {
    public static void main(String[] args) {

        //无限递归调用main方法，程序运行最终会StackOverFlowError
        main(args);

    }
}
