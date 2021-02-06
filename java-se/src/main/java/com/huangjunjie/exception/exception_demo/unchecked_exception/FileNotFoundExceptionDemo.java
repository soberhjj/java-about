package com.huangjunjie.exception.exception_demo.unchecked_exception;

import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**
 * @author huangJunJie 2021-02-06-13:24
 * 编译时异常：FileNotFoundException 举例
 *
 */
public class FileNotFoundExceptionDemo {

    //下面如果不throws FileNotFoundException的话，那么是无法通过编译的，编译时会报FileNotFoundException
    @Test
    public void demo1() throws FileNotFoundException {
        File file = new File("E:hello.txt");
        FileInputStream fis = new FileInputStream(file);

    }
}
