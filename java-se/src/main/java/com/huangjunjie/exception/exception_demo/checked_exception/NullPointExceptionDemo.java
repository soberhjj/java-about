package com.huangjunjie.exception.exception_demo.checked_exception;

import org.junit.Test;

/**
 * @author huangJunJie 2021-02-06-13:24
 * <p>
 * NullPointerException举例
 */
public class NullPointExceptionDemo {

    @Test
    public void demo1() {
        int[] arr = null;
        System.out.println(arr[0]);
    }

    @Test
    public void demo2() {
        String aa = null;
        System.out.println(aa.charAt(0));

    }
}
