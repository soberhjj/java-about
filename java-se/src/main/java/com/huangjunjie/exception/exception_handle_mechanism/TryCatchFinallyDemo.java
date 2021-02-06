package com.huangjunjie.exception.exception_handle_mechanism;

import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

/**
 * @author huangJunJie 2021-02-06-14:30
 */
public class TryCatchFinallyDemo {
    @Test
    public void demo1() {
        String str = "aaa";
        try {
            //可能会出现数值转换异常
            int num = Integer.parseInt(str);
        } catch (NumberFormatException e) {
            //出现数值转换异常时的异常处理逻辑
            System.out.println("出现数值转换异常了，不慌");
        }
    }

    @Test
    public void demo2() {
        List list = new LinkedList();
        list.add(1);
        list.add(2);
        list.add("abc");
        list.add(3);
        list.add(4);
        for (Object obj : list) {
            try {
                //可能会出现类型转换异常
                Integer num = (Integer) obj;
                System.out.println(num);
            } catch (ClassCastException e) {
                //出现类型转换异常时的异常处理逻辑
                System.out.println("出现类型转换异常了，不慌");
            }
        }

    }


    @Test
    public void demo3() {
        int num = method();
        System.out.println(num);
    }

    public int method() {
        String str = "1";
        try {
            //可能会出现数值转换异常
            int num = Integer.parseInt(str);
            return 1;
        } catch (NumberFormatException e) {
            //出现数值转换异常时的异常处理逻辑
            System.out.println("出现数值转换异常了，不慌");
            return 2;

        } finally {
            return 3;
        }
    }

    @Test
    public void demo4() {
        int[] a = {1, 2, 3, 4, 5, 6};
        for (int i = 0; i < 8; i++) {
            try {
                int temp=a[i];
                System.out.println(temp);
            }catch (ArrayIndexOutOfBoundsException e){
                System.out.println("数组下标越界了");
            }
        }
        System.out.println("程序执行结束");
    }
}
