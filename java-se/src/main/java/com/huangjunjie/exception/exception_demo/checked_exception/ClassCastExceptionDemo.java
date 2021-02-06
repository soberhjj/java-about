package com.huangjunjie.exception.exception_demo.checked_exception;

import org.junit.Test;

import java.util.Date;

/**
 * @author huangJunJie 2021-02-06-13:33
 *    ClassCastException 类型转换异常 举例
 */
public class ClassCastExceptionDemo {

    @Test
    public void demo1() {
        Object obj=new Date();
        String str=(String)obj;
        System.out.println(str);
    }
}
