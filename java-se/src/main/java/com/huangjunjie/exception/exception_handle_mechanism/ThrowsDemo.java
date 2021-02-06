package com.huangjunjie.exception.exception_handle_mechanism;

import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**
 * @author huangJunJie 2021-02-06-15:58
 */
public class ThrowsDemo {
    @Test
    public void demo() {
        try {
            int num = method();
            System.out.println(num);
        }catch (NumberFormatException e){
            System.out.println("出现了数值转换异常");
        }
        System.out.println("异常捕获处理后，程序继续执行");

    }


    public int method() throws NumberFormatException {
        String str = "aaa";
        int num = Integer.parseInt(str);
        return num;

    }

    @Test
    public void demo1() {
        try {
            method1();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }

    public void method1() throws FileNotFoundException {
        File file=new File("E:hello.txt");
        FileInputStream fis=new FileInputStream(file);

    }
}
