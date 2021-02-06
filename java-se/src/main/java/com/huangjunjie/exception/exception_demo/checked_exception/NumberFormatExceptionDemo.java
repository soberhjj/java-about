package com.huangjunjie.exception.exception_demo.checked_exception;

import org.junit.Test;

/**
 * @author huangJunJie 2021-02-06-13:33
 *
 *
 */
public class NumberFormatExceptionDemo {

    @Test
    public void demo1() {
        String a="abc";
        Integer b=Integer.parseInt(a);
        System.out.println(b);

    }
}
