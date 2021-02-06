package com.huangjunjie.exception.exception_demo.checked_exception;

import org.junit.Test;

/**
 * @author huangJunJie 2021-02-06-13:24
 * <p>
 * ArrayOutOfBoundsException和StringIndexOutOfBoundsException 举例
 */
public class ArrayOutOfBoundsExceptionDemo {

    //ArrayOutOfBoundsException例子
    @Test
    public void demo1() {
        int[] arr = {1,2,3,4,5};
        System.out.println(arr[5]);
    }

    //StringIndexOutOfBoundsException例子
    @Test
    public void demo2() {
        String aa="abc";
        System.out.println(aa.charAt(3));
    }

}
