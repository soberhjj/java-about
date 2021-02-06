package com.huangjunjie.exception;

/**
 * @author huangJunJie 2021-02-06-12:39
 *
 *          程序运行Error举例
 */
public class ErrorDemo2 {
    public static void main(String[] args) {

        //堆空间不够，程序运行会OutOfMemoryError
        Integer [] arr=new Integer[1024*1024*1024];

    }
}
